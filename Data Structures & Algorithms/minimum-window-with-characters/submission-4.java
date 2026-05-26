class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++) 
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        int left = 0, count = 0, minLength = Integer.MAX_VALUE, start = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(map.containsKey(c)) {
                if(map.get(c) > 0) {
                    count++;
                }
                map.put(c, map.get(c)-1);
            }
            while(count == t.length()) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftInd = s.charAt(left++);
                if(map.containsKey(leftInd)) {
                    map.put(leftInd, map.get(leftInd) + 1);
                    if(map.get(leftInd) > 0) count--;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
