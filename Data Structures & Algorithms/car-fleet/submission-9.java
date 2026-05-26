class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        for(int i=0; i<position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        double[] s = new double[position.length];
        int top = -1;
        for(int i=position.length-1; i>=0; i--) {
            double eval = (double)(target - arr[i][0]) / arr[i][1];
            if(top >= 0 && s[top] >= eval) continue;
            s[++top] = eval;
        }
        return top + 1;
    }
}
