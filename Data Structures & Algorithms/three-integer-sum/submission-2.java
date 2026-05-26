class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j=i+1; j<nums.length; j++) {
                int d = 0 - nums[i] - nums[j];
                if(map.containsKey(d)) {
                    List<Integer> lst = Arrays.asList(nums[i], nums[j], d);
                    Collections.sort(lst);
                    ans.add(lst);
                }
                map.put(nums[j], j);
            }
        }

        return new ArrayList<>(ans);
    }
}
