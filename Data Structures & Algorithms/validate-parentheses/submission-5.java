class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!stk.isEmpty() && ((c == ')' && stk.peek() == '(') || (c == ']' &&  stk.peek() == '[') || (c == '}' && stk.peek() == '{'))) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}
