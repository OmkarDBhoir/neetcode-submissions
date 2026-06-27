class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return combinationSum(nums, 0, target, new ArrayList<>());       
    }

    private List<List<Integer>> combinationSum(int[] nums, int index, int target, List<Integer> lst) {
        List<List<Integer>> ans = new ArrayList<>();
        if(target < 0) {
            return ans;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(lst));
            return ans;
        }
        if(index == nums.length) {
            return ans;
        }
        lst.add(nums[index]);
        ans.addAll(combinationSum(nums, index, target-nums[index], lst));
        lst.remove(lst.size()-1);       
        ans.addAll(combinationSum(nums, index+1, target, lst)); 
        return ans;
    }
}
