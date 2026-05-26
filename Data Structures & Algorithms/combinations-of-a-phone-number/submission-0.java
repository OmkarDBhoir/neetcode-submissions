class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits == null || digits.isEmpty()) return ans;
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generate(digits, "", 0, ans, letters);
        return ans;
    }

    public void generate(String digits, String p, int index, List<String> ans, String[] letters) {
        if(index == digits.length()) {
            ans.add(p);
            return;
        }
        String letter = letters[digits.charAt(index) - '0'];
        for(int i=0; i<letter.length(); i++) {
            generate(digits, p+letter.charAt(i), index+1, ans, letters);
        }
    }
}
