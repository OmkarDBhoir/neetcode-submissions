class MinStack {
    Deque<int[]> s = null;

    public MinStack() {
        s = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int min = s.isEmpty() ? val : Math.min(s.peek()[1], val);
        s.push(new int[]{val, min});
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek()[0];
    }
    
    public int getMin() {
        return s.peek()[1];
    }
}
