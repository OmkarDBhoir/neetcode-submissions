class Solution {
    public List<String> generateParenthesis(int n) {
        return generate("", 0, 0, n);
    }

    public List<String> generate(String p, int l, int r, int n) {
        List<String> ans = new ArrayList<>();
        if(p.length() == 2 * n) {
            ans.add(p);
            return ans;
        }

        if(l < n) {
            ans.addAll(generate(p+'(', l+1, r, n));
        }
        if(r < l) {
            ans.addAll(generate(p+')', l, r+1, n));
        }

        return ans;
    }
}
