class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void subsets(int[] nums, int index, List<Integer> lst, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(lst));
        for(int i=index; i<nums.length; i++) {
            if(i != index && nums[i] == nums[i-1]) continue;
            lst.add(nums[i]);
            subsets(nums, i+1, lst, ans);
            lst.remove(lst.size()-1);
        }

    }
}
