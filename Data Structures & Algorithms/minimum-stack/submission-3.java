class MinStack {

    int[] s = null;
    int[] minS = null;
    int top;
    int mTop;

    public MinStack() {
        s = new int[30000];
        minS = new int[30000];
        top = -1;
        mTop = -1;
    }
    
    public void push(int val) {
        s[++top] = val;
        if(mTop == -1 || minS[mTop] >= val) minS[++mTop] = val;
    }
    
    public void pop() {
        if(minS[mTop] == s[top]) mTop--;
        top--;
    }
    
    public int top() {
        return top < 0 ? -1 : s[top];   
    }
    
    public int getMin() {
        return mTop < 0 ? -1 : minS[mTop];
    }
}
