class Solution {
    public int evalRPN(String[] tokens) {
        int[] stk = new int[tokens.length];
        int top = -1;
        for(String s: tokens) {
            if(isOp(s)) {
                if(s.equals("+")) stk[top-1] = stk[top-1] + stk[top];
                if(s.equals("-")) stk[top-1] = stk[top-1] - stk[top];
                if(s.equals("*")) stk[top-1] = stk[top-1] * stk[top];
                if(s.equals("/")) stk[top-1] = stk[top-1] / stk[top];
                top--;
            } else {
                stk[++top] = Integer.parseInt(s);
            }
        }
        return stk[top];
    }

    public boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
