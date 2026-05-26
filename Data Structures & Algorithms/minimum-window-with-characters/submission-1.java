class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++) {
            int[] map  = new int[256];
            for(int j=0; j<t.length(); j++) map[t.charAt(j)]--;
            int count = 0;
            int len = 0;
            for(int j=i; j<s.length(); j++) {
                char c = s.charAt(j);
                if(map[c] < 0) {
                    map[c]++;
                    count++;
                }
                len++;
                if(count == t.length()) break;
            }
            if(count >= t.length() && len <= minLength) {
                ans = s.substring(i, i+len);
                minLength = len;
            }
        }
        return ans;
    }
}
