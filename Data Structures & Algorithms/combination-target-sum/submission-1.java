class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    
    public void generate(int[] nums, int index, int target, List<Integer> lst, List<List<Integer>> ans) {
        if(index >= nums.length || target <= 0) {
            if(target == 0) {
                ans.add(new ArrayList<>(lst));
            }
            return;
        }
        for(int i=index; i<nums.length; i++) {
            lst.add(nums[i]);
            generate(nums, i, target-nums[i], lst, ans);
            lst.remove(lst.size()-1);
        }
    } 
}
