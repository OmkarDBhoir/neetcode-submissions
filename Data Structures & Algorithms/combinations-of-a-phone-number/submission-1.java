class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        combination(new StringBuilder(), digits, 0, letters, ans);
        return ans;
    }

    public void combination(StringBuilder p, String digits, int index, String[] letters, List<String> ans) {
        if(index == digits.length()) {
            ans.add(p.toString());
            return;
        }
        String word = letters[digits.charAt(index) - '0'];
        for(int i=0; i<word.length(); i++) {
            p.append(word.charAt(i));
            combination(p, digits, index+1, letters, ans);
            p.setLength(p.length()-1);
        }
    }
}
