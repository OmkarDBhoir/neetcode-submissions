class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void subset(int[] nums, int index, List<Integer> lst, List<List<Integer>> ans) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[index]);
        subset(nums, index + 1,  lst, ans);
        lst.remove(lst.size() - 1);
        subset(nums, index + 1, lst, ans);
    }
}
