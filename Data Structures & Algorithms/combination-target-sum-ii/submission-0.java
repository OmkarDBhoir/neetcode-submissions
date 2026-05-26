class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        generate(candidates, 0, target, new ArrayList<>(), ans);
        return new ArrayList<>(ans);   
    }

    public void generate(int[] nums, int index, int target, List<Integer> lst, Set<List<Integer>> ans) {
        if(index == nums.length || target <= 0) {
            if(target == 0) {
                ans.add(new ArrayList<>(lst));
            }
            return;
        }

        for(int i=index; i<nums.length; i++) {
            lst.add(nums[i]);
            generate(nums, i+1, target-nums[i], lst, ans);
            lst.remove(lst.size() - 1);
        }
    }
}
