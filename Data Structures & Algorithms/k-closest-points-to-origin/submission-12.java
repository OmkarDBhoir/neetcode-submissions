class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> Integer.compare(dist(b), dist(a)));
        for(int i=0; i<points.length; i++) {
            q.offer(points[i]);
            if(q.size() > k) q.poll();
        }
        int[][] ans = new int[k][2];
        for(int i=0; i<k && !q.isEmpty(); i++) {
            ans[i] = q.poll();
        }
        return ans;
    }

    public int dist(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
