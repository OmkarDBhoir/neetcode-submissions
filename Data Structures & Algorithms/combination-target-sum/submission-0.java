class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        generate(nums, 0, target, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    public void generate(int[] nums, int index, int target, List<Integer> lst, Set<List<Integer>> ans) {
        if(target < 0) return;
        if(index == nums.length) {
            if(target == 0) {
                ans.add(new ArrayList<Integer>(lst));
            }
            return;
        }
        lst.add(nums[index]);
        generate(nums, index, target-nums[index], lst, ans);
        lst.remove(lst.size()-1);
        generate(nums, index+1, target, lst, ans);
    }
}
