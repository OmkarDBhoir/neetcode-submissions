class MinStack {
    Stack<int[]> s = null;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if(!s.isEmpty()) {
            min = Math.min(s.peek()[1], val);
        }
        s.push(new int[]{val, min});
    }
    
    public void pop() {
        if(!s.isEmpty())
            s.pop();
    }
    
    public int top() {
        return s.isEmpty() ? -1 : s.peek()[0];
    }
    
    public int getMin() {
        return s.isEmpty() ? -1 : s.peek()[1];
    }
}
