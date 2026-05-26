class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int prod = 1;
        int[] result = new int[nums.length];
        for(int n: nums)  {
            if(n == 0) zeroCount++;
            else prod *= n;
        }
        if(zeroCount > 1) return result;
        if(zeroCount == 1) {
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
