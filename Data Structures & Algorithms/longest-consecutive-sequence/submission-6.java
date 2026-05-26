class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }  
        for(int i: set) {
            if(!set.contains(i-1)) {
                int last = i;
                int len = 1;
                while(set.contains(last+1)) {
                    last = last+1;
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}
