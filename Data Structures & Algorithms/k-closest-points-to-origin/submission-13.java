class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> Integer.compare(dist(b), dist(a)));
        for(int i=0; i<points.length; i++) {
            q.offer(points[i]);
            if(q.size() > k) q.poll();
        }
        return q.toArray(new int[q.size()][]);
    }

    public int dist(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
