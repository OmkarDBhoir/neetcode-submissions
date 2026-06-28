class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        int start = 0;
        for(int i=0; i<nums.length; i++) {
            int size = ans.size();
            int begin = i > 0 && nums[i] == nums[i-1] ? start : 0;
            start = size;
            for(int j=begin; j<size; j++) {
                List<Integer> lst = new ArrayList<>(ans.get(j));
                lst.add(nums[i]);
                ans.add(lst);
            }
        }

        return ans;
    }
}
