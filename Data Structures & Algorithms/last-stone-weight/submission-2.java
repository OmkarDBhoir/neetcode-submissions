class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i: stones) {
            q.offer(i);
        }   
        while(q.size() > 1) {
            Integer x = q.poll();
            Integer y = q.poll();
            q.offer(Math.abs(x - y));
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}
