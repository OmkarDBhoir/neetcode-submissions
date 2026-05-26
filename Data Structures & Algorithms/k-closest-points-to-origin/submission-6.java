class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
        int[][] ans = new int[k][2];
        for(int i=0; i<points.length; i++) {
            q.offer(points[i]);
            if(q.size() > k) q.poll();
        }
        int i = 0;
        while(!q.isEmpty()) {
            ans[i++] = q.poll();
        }

        return ans;
    }
}
