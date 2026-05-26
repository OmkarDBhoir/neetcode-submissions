class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length-1;
        int start = 0, end = matrix.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] <= target && matrix[mid][m] >= target)
                return binarySearch(matrix[mid], target);
            if(matrix[mid][m] < target) start = mid + 1;
            else end = mid - 1;
        }   
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] < target) start = mid + 1;
            else end = mid - 1; 
        }

        return false;
    }
}
