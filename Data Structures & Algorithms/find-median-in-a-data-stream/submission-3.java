class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if(left.size() < right.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()) {
            return left.peek();
        } else {
            return (left.peek() + right.peek()) / 2D;
        }
    }
}
