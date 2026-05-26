class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }
        int max = 0;
        for(int i: nums) {
            if(!set.contains(i-1)) {
                int j = i;
                while(set.contains(j)) {
                    j++;
                }
                max = Math.max(max, j - i);
            }
        }

        return max;
    }
}
