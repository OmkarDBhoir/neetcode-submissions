class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') stk.push(c);
            else {
                if(stk.isEmpty() || !isClosing(stk.peek(), c)) return false;
                stk.pop();
            }
        }
        return stk.isEmpty();
    }

    public boolean isClosing(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
