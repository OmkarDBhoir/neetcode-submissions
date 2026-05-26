class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1;
        int n = matrix.length;
        int m = matrix[0].length;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target) {
                return binarySearch(matrix[mid], target);
            } else  if(matrix[mid][m-1] < target) start = mid + 1;
            else end = mid - 1; 
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
