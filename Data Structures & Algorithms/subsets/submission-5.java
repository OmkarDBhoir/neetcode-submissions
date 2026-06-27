class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subset(nums, 0, new ArrayList<>());
    }

    public List<List<Integer>> subset(int[] nums, int index, List<Integer> lst) {
        List<List<Integer>> ans = new ArrayList<>();
        if(index == nums.length) {
            ans.add(new ArrayList<>(lst));
            return ans;
        }
        lst.add(nums[index]);
        ans.addAll(subset(nums, index + 1,  lst));
        lst.remove(lst.size() - 1);
        ans.addAll(subset(nums, index + 1,  lst));
        return ans;
    }
}
