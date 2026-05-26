class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1, end = nums.length-1;
            while(start < end) {
                long sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    ans.add(List.of(nums[i], nums[start], nums[end]));
                    while(start < end && nums[start] == nums[start+1]) start++;
                    while(start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--; 
                } else if(sum < 0) start++;
                else end--;
            }
        }   
        return ans;
    }
}
