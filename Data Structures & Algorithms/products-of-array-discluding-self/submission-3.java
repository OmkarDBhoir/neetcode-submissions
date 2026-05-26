class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int prod = 1;
        for(int i: nums) {
            if(i == 0) count++;
            else prod *= i;
        }
        int[] result = new int[nums.length];
        if(count > 1) return result;
        if(count == 1) {
            for(int i=0; i<nums.length; i++) {
                if(nums[i] == 0) result[i] = prod;
            }
        } else {
            for(int i=0; i<nums.length; i++) {
                result[i] = prod / nums[i];
            }
        }

        return result;
    }
}  
