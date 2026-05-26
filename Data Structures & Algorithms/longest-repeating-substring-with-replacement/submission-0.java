class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            int[] map = new int[26];
            int maxFreq = 0;
            for(int j=i; j<s.length(); j++) {
                int cInd = s.charAt(j) - 'A';
                map[cInd]++;
                maxFreq = Math.max(maxFreq, map[cInd]);
                int len = j - i + 1;
                if(len - maxFreq > k) break;
                max = Math.max(max, j - i + 1);
            }

        }

        return max;
    }
}
