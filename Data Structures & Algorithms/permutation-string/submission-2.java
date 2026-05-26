class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(int j=0; j<s1.length(); j++) map[s1.charAt(j) - 'a']++;
        for(int i=0; i<s2.length(); i++) {
            int[] freqMap = map.clone();
            if(freqMap[s2.charAt(i) - 'a'] > 0) {
                int count = 0; 
                for(int j=i; j<s2.length(); j++) {
                    int cInd = s2.charAt(j) - 'a';
                    if(freqMap[cInd] <= 0) break;
                    count++;
                    freqMap[cInd]--;
                }

                if(count == s1.length()) return true;
            }
        }
        return false;
    }
}
