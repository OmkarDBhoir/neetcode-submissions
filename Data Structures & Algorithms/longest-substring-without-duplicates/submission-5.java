class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int left = 0, maxLen = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(map[c] !=  -1) {
                left = Math.max(left, map[c] + 1);
            }
            map[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
