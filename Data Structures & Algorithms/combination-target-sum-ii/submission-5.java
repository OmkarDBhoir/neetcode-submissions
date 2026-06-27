class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, 0, target, new ArrayList<>());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int index, int target, List<Integer> lst) {
        List<List<Integer>> ans = new ArrayList<>();
        if(target <= 0 || index == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(lst));
            }
            return ans;
        }
        for(int i=index; i<candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            lst.add(candidates[i]);
            ans.addAll(combinationSum2(candidates, i+1, target-candidates[i], lst));
            lst.remove(lst.size()-1);
        }
        return ans;
    }
}
