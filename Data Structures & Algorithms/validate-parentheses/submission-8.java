class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();   
        int top = -1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(top > -1 && ((sb.charAt(top) == '(' && c == ')') || (sb.charAt(top) == '[' && c == ']') || (sb.charAt(top) == '{' && c == '}'))) {
                top--;
                sb.setLength(sb.length()-1);
            } else {
                sb.append(c);
                top++;
            }
        }
        System.out.println(sb.toString() + " "  + top);
        return top == -1;
    }
}
