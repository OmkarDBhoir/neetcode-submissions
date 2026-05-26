class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int curr = 0;
        int farthes = 0;
        for(int i=0; i<nums.length - 1; i++) {
            farthes = Math.max(farthes, i + nums[i]);

            if(i == curr) {
                jumps++;
                curr = farthes;
            }
        }

        return jumps;
    }
}
