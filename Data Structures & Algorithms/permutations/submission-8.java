class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    public List<List<Integer>> permute(int[] nums, int index) {
        List<List<Integer>> ans = new ArrayList<>();
        if(index == nums.length - 1) {
            List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(lst);
            return ans;
        }
        for(int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            ans.addAll(permute(nums, index+1));
            swap(nums, index, i);
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
