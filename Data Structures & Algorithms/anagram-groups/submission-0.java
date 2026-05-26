class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++) {
            String sorted = sort(strs[i]);
            map.computeIfAbsent(sorted, k -> new ArrayList<String>()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
