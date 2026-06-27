class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, new boolean[nums.length], new ArrayList<>());
    }

    public List<List<Integer>> permute(int[] nums, boolean[] visited, List<Integer> lst) {
        List<List<Integer>> ans = new ArrayList<>();
        if(lst.size() == nums.length) {
            ans.add(new ArrayList<>(lst));
            return ans;
        }
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            lst.add(nums[i]);
            visited[i] = true;
            ans.addAll(permute(nums, visited, lst));
            visited[i] = false;
            lst.remove(lst.size()-1);
        }
        return ans;
    }
}
