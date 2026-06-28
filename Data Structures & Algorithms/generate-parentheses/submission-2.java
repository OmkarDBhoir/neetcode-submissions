class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    public void generate(StringBuilder p, int l, int r, int n, List<String> lst) {
        if(p.length() == 2 * n) {
            lst.add(p.toString());
            return;
        }
        if(l < n) {
            p.append('(');
            generate(p, l+1, r, n, lst);
            p.setLength(p.length()-1);
        }
        if(r < l) {
            p.append(')');
            generate(p, l, r+1, n, lst);
            p.setLength(p.length()-1);
        }
    }
}
