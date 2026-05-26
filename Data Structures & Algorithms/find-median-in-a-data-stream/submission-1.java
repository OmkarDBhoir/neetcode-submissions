class MedianFinder {

    List<Integer> nums = null;

    public MedianFinder() {
        nums = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for(int i: nums) {
            q.offer(i);
        }
        int prev = 0;
        int next = 0;
        int limit = (nums.size() - 1) / 2;
        while(!q.isEmpty() && q.size() > limit) {
            prev = next;
            next = q.poll();
        }

        return nums.size() % 2 == 0 ? (prev + next) / 2D : next;
    }
}
