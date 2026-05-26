class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length-1, k);
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

    public void quickSelect(int[][] points, int left, int right, int k) {
        if(left >= right) return;
        int pivotInd = partition(points, left, right);
        if(pivotInd == k-1) return;
        if(pivotInd < k - 1) {
            quickSelect(points, pivotInd+1, right, k);
        } else {
            quickSelect(points, left, pivotInd-1, k);
        }
    }

    public int partition(int[][] points, int left, int right) {
        int[] pivit = points[right];
        int pDist = dist(pivit);
        int i = left;
        for(int j=i; j<right; j++) {
            if(dist(points[j]) <= pDist) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, right);
        return i;
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public int dist(int[] p) {
        return p[0] * p[0] + p[1]  * p[1];
    }
}
