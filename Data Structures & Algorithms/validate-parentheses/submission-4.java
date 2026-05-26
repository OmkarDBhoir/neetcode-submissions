class Solution {
    public boolean isValid(String s) {
        boolean changed = true;
        while(changed) {
            changed = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                if(i < s.length() - 1 && isPair(s.charAt(i), s.charAt(i+1))) {
                    changed = true;
                    i++;
                } else {
                    sb.append(s.charAt(i));
                }
            }

            s = sb.toString();
        }

        return s.isEmpty();
    }

    public boolean isPair(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
