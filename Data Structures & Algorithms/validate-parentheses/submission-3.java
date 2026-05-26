class Solution {
    public boolean isValid(String s) {
        while(true) {
            int len = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
            if(s.length() == len) break;
        }

        return s.isEmpty();
    }
}
