class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0, ans);
        return ans;
    }

    public void permute(int[] nums, int index, List<List<Integer>> ans) {
        if(index == nums.length) {
            List<Integer> lst = new ArrayList<Integer>();
            for(int i: nums) lst.add(i);
            ans.add(lst);
            return;
        }

        for(int i=index; i<nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index+1, ans);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
