class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i=0; i<s.length(); i++) {
            int[] chars = new int[256];
            int len = 0;
            for(int j=i; j<s.length(); j++) {
                char c = s.charAt(j);
                if(chars[c] > 0) break;
                chars[c]++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }


        return maxLen;
    }
}
