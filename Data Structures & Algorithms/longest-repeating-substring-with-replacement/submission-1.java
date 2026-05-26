class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int maxFreq = 0, left = 0, max = 0;
        for(int right=0; right<s.length(); right++) {
            int cInd = s.charAt(right) - 'A';
            map[cInd]++;
            maxFreq = Math.max(maxFreq, map[cInd]);
            while(right - left + 1 - maxFreq > k) {
                map[s.charAt(left++) - 'A']--;
                for(int i=0; i<map.length; i++) max = Math.max(maxFreq, map[i]);
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
