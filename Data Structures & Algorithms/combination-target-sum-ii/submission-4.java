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
        lst.add(candidates[index]);
        ans.addAll(combinationSum2(candidates, index+1, target-candidates[index], lst));
        lst.remove(lst.size()-1);
        int skipIndex = index + 1;
        while(skipIndex < candidates.length && candidates[skipIndex] == candidates[index]) skipIndex++;
        ans.addAll(combinationSum2(candidates, skipIndex, target, lst));
        return ans;
    }
}
