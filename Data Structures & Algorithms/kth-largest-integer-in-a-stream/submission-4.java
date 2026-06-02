class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i: nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size() > k) q.poll();
        return q.peek();
    }
}
