class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, int[]>> q = new PriorityQueue<Pair<Double, int[]>>((a, b) -> Double.compare(b.first(), a.first()));
        int[][] ans = new int[k][2];
        double log2 = Math.log(2);
        for(int i=0; i<points.length; i++) {
            int x = (int) Math.pow(points[i][0] - 0, 2);
            int y = (int) Math.pow(points[i][1] - 0, 2);
            Double z = Math.sqrt(x + y);
            q.offer(new Pair<>(z, points[i]));
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
