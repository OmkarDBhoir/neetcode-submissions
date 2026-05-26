class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(int j=0; j<s1.length(); j++) map[s1.charAt(j) - 'a']++;
        int left = 0, count = 0;
        for(int right=0; right<s2.length(); right++) {
            int cInd = s2.charAt(right) - 'a';
            map[cInd]--;
            if(map[cInd] >= 0) count++;
            if(right - left + 1 > s1.length()) {
                int ind = s2.charAt(left) - 'a';
                if(map[ind] >= 0) count--;
                map[ind]++;
                left++;
            }

            if(count == s1.length()) return true;
        }
        return false;
    }
}
