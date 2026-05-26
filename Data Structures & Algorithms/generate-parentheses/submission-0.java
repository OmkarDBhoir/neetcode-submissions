class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();   
        generate("", 0, 0, n, ans);
        return ans;
    }

    public void generate(String p, int l, int r, int n, List<String> ans) {
        if(p.length() == 2 * n) {
            ans.add(p);
            return;
        }

        if(l < n) {
            generate(p+'(', l+1, r, n, ans);
        }
        if(r < l) {
            generate(p+')', l, r+1, n, ans);
        }
    }
}
