class MinStack {

    private Stack<Integer> s = null;
    private Stack<Integer> minS = null;

    public MinStack() {
        s = new Stack<Integer>();
        minS = new Stack<Integer>();
    }
    
    public void push(int val) {
        s.push(val);
        if(minS.isEmpty() || minS.peek() >= val) minS.push(val);
    }
    
    public void pop() {
        if(!s.isEmpty()) {
            if(!minS.isEmpty() && minS.peek().equals(s.peek())) minS.pop();
            s.pop();
        }
    }
    
    public int top() {
        return s.isEmpty() ? -1 : s.peek();
    }
    
    public int getMin() {
        return minS.isEmpty() ? -1 : minS.peek();   
    }
}
