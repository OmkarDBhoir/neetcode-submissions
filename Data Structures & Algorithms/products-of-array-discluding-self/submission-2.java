class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int count = 0;
        for(int i: nums) {
            if(i == 0) count++;
        }
        if(count > 1) return result;
        int prod = 1;
        for(int i: nums) {
            if(i != 0) prod *= i;
        }
        if(count == 1) {
            for(int i=0; i<nums.length; i++) {
                result[i] = nums[i] == 0 ? prod : 0;
            }
        } else {
            for(int i=0; i<nums.length; i++) {
                result[i] = prod / nums[i];
            }
        }
        return result;
    }
}  
