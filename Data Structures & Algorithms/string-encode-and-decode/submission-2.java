class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<String>();
        int i=0;
        while(i < str.length()) {
            int j = i;
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
