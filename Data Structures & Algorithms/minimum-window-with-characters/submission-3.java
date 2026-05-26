class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int[] map  = new int[256];
        for(int j=0; j<t.length(); j++) map[t.charAt(j)]++;
        int left = 0;
        int count = 0;
        int start = 0;
        for(int right = 0; right < s.length(); right++) {
            int c = s.charAt(right);
            if(map[c] > 0) count++;
            map[c]--;
            while(count == t.length()) {
                if(right - left + 1 < minLength) {
                    minLength = right - left  + 1;
                    start = left;
                }
                int leftInd = s.charAt(left++);
                map[leftInd]++;
                if(map[leftInd] > 0) count--;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start+minLength);
    }
}
