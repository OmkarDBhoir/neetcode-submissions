class MedianFinder {
    List<Integer> nums = null;

    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        Collections.sort(nums);
        int m = (nums.size() - 1) / 2;
        return nums.size() % 2 == 0 ? (nums.get(m) + nums.get(m + 1)) / 2D : nums.get(m);
    }
}
