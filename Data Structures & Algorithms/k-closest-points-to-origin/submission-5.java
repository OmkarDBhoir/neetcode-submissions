class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> q = new PriorityQueue<Pair<Integer, int[]>>((a, b) -> Integer.compare(b.first(), a.first()));
        int[][] ans = new int[k][2];
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            q.offer(new Pair<>(x * x + y * y, points[i]));
            if(q.size() > k) q.poll();
        }
        int i = 0;
        while(!q.isEmpty()) {
            ans[i++] = q.poll().second();
        }

        return ans;
    }

    private record Pair<K, V>(K first, V second) {}
}
