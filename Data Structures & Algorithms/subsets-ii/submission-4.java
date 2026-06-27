class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void subset(int[] nums, int index, List<Integer> lst, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(lst));
        for(int i=index; i<nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            lst.add(nums[i]);
            subset(nums, i+1, lst, ans);
            lst.remove(lst.size()-1);
        }
    }
}
