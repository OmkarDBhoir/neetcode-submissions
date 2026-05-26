class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();   
        for(int i=0; i<s.length(); i++) {
            int top = sb.length() - 1;
            char c = s.charAt(i);
            if(top >= 0 && ((sb.charAt(top) == '(' && c == ')') || (sb.charAt(top) == '[' && c == ']') || (sb.charAt(top) == '{' && c == '}'))) {
                sb.setLength(sb.length()-1);
            } else {
                sb.append(c);
                top++;
            }
        }
        return sb.length() == 0;
    }
}
