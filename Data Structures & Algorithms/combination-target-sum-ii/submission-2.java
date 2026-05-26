class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        generate(candidates, 0, target, new ArrayList<>(), ans);
        return ans;   
    }

    public void generate(int[] nums, int index, int target, List<Integer> lst, List<List<Integer>> ans) {
        if(index == nums.length || target <= 0) {
            if(target == 0) {
                ans.add(new ArrayList<>(lst));
            }
            return;
        }

        for(int i=index; i<nums.length; i++) {
            if(i != index && nums[i] == nums[i-1]) continue;
            lst.add(nums[i]);
            generate(nums, i+1, target-nums[i], lst, ans);
            lst.remove(lst.size() - 1);
        }
    }
}
