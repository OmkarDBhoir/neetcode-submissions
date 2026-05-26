class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            int size = ans.size();
            for(List<Integer> l: ans) {
                List<Integer> lst = new ArrayList<>(l);
                lst.add(nums[i]);
                temp.add(lst);
            }
            ans.addAll(temp);
        }

        return new ArrayList<>(ans);
    }
}
