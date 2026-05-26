class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, new boolean[nums.length], 0, new ArrayList<>(), ans);
        return ans;
    }

    public void permute(int[] nums, boolean[] visited, int index, List<Integer> lst, List<List<Integer>> ans) {
        if(lst.size() == nums.length) {
            ans.add(new ArrayList<Integer>(lst));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                lst.add(nums[i]);
                permute(nums, visited, i, lst, ans);
                lst.remove(lst.size()-1);
                visited[i] = false;
            }
        }
    }
}
