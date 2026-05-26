class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int seq = nums[i] + 1;
            int len = 1;
            while(isPresent(nums, seq)) {
                boolean isPresent = true;
                for(int j=0; j<nums.length; j++) {
                    if(nums[j] == seq) {
                        seq++;
                        len++;
                        isPresent = true;
                        break;
                    }
                }
                if(!isPresent) break;
            }
            max = Math.max(max, len);
        }

        return max;
    }

    public boolean isPresent(int[] nums, int n) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == n) return true;
        }

        return false;
    }
}
