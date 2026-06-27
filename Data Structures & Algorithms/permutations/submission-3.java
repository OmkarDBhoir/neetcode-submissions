class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, new ArrayList<>());
    }

    public List<List<Integer>> permute(int[] nums, int index, List<Integer> lst) {
        List<List<Integer>> ans = new ArrayList<>();
        if(lst.size() == nums.length) {
            ans.add(new ArrayList<>(lst));
            return ans;
        }
        for(int i=0; i<nums.length; i++) {
            if(lst.contains(nums[i])) continue;
            lst.add(nums[i]);
            ans.addAll(permute(nums, index+1, lst));
            lst.remove(lst.size()-1);
        }
        return ans;
    }
}
