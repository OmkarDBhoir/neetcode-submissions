class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i: stones) {
            q.offer(i);
        }

        while(q.size() > 1) {
            int max1 = q.poll();
            int max2 = q.poll();
            if(max1 > max2) {
                q.offer(max1 - max2);
            }
        }

        return q.isEmpty() ? 0 : q.peek();
    }
}
