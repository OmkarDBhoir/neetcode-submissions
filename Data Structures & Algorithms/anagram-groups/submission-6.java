class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            map.computeIfAbsent(hashKey(s), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public String hashKey(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i: freq) {
            sb.append("#");
            sb.append(i);
        }

        return sb.toString();
    }
}
