class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> lst = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]});
                        Collections.sort(lst);
                        ans.add(lst);
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
