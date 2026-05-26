class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int left = 0, max = 0, maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'A';
            map[c]++;
            maxFreq = Math.max(maxFreq, map[c]);
            while(right - left + 1 - maxFreq > k) {
                map[s.charAt(left++) - 'A']--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
