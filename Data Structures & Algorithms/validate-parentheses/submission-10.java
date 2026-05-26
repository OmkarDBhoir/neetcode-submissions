class Solution {
    public boolean isValid(String s) {
        char[] stk = new char[s.length()];
        int top = -1;
        for(char c: s.toCharArray()) {
            if(top > -1 && ((stk[top] == '(' && c == ')') || (stk[top] == '[' && c == ']') || (stk[top] == '{' && c == '}'))) {
                top--;
            } else {
                stk[++top] = c;
            }
        }
        return top == -1;
    }
}
