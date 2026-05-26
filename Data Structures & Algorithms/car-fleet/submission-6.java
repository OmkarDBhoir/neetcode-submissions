class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        for(int i=0; i<position.length; i++) {
            arr[i] = new int[]{position[i], speed[i]};
        }   

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        double[] stk = new double[position.length];
        int top = -1;
        for(int i=arr.length-1; i>=0; i--) {
            double eval = (double)(target - arr[i][0]) / arr[i][1];
            if(top > -1 && stk[top] >= eval) continue;
            stk[++top] = eval;
        }
        return top + 1;
    }
}
