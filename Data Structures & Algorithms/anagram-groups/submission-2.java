class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            String sorted = sort(s);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
