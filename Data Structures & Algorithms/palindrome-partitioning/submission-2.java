class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void partition(String s, int index, List<String> lst, List<List<String>> ans) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            if(isPalindrom(s, index, i)) {
                lst.add(s.substring(index, i+1));
                partition(s, i+1, lst, ans);
                lst.remove(lst.size()-1);
            }
        }
    }

    public boolean isPalindrom(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
