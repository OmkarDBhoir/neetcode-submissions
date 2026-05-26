class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++) {
            String key = hashKey(strs[i]);
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public String hashKey(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder str = new StringBuilder();
        for(int i: freq) {
            str.append("#");
            str.append(i);
        }

        return str.toString();
    }
}
