class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for(String str: tokens) {
            if(isOperand(str)){
                int a = s.pop();
                int b = s.pop();
                int c = eval(b, a, str); 
                s.push(c);
            }
            else {
                s.push(Integer.parseInt(str));
            }

            System.out.println(s);
        }

        return s.isEmpty() ? -1 : s.pop();
    }

    public boolean isOperand(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    public int eval(int a, int b, String c) {
        if(c.equals("+")) return a + b;
        if(c.equals("-")) return a - b;
        if(c.equals("*")) return a * b;
        if(c.equals("/")) return a / b;
        return -1;
    }
}
