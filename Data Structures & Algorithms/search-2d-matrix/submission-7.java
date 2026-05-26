class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = n-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target) {
                int left = 0, right = m-1;
                while(left <= right) {
                    int m1 = left + (right - left) / 2;
                    if(matrix[mid][m1] == target) return true;
                    else if(matrix[mid][m1] < target) left = m1 + 1;
                    else right = m1 - 1;
                }
                return false;
            } else if(matrix[mid][m-1] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
