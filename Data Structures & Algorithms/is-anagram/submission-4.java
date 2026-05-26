class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqMap = new int[26];
        for(char c : s.toCharArray()) {
            freqMap[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            freqMap[c - 'a']--;
        }

        for(int i: freqMap) {
            if(i != 0) return false;
        }

        return true;
    }
}
