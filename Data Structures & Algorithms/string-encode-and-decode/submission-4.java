class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String s: strs) {
            ans.append(s.length()).append("#").append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i < str.length()) {
            int j=i;
            while(j < str.length() && str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            String word = str.substring(j, j+length);
            ans.add(word);
            i = j + length;
        }
        return ans;
    }
}
