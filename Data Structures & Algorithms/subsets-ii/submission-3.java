class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
        subset(nums, index+1, lst, ans);
        lst.remove(lst.size()-1);
        int next = index+1;
        while(next < nums.length && nums[next] == nums[next-1]) next++;;
        subset(nums, next, lst, ans);
    }
}
