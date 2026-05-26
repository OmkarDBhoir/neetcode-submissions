class KthLargest {

    List<Integer> nums = null;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            this.nums.add(nums[i]);
        }
        buildHeap();
    }

    public void buildHeap() {
        for(int i=nums.size()/2 - 1; i>=0; i--)
            heapify(nums, i);
    }

    public void heapify(List<Integer> nums, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < nums.size() && nums.get(left) > nums.get(largest)) {
            largest = left;
        }
        if(right < nums.size() && nums.get(right) > nums.get(largest)) {
            largest = right;
        }
        if(largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest);
        }
    }
    
    public int add(int val) {
        nums.add(val);
        buildHeap();
        return getKthLargest();
    }

    private int getKthLargest() {
        List<Integer> copy = new ArrayList<Integer>(nums);
        int result = -1;
        int size = copy.size();
        for(int i=0; i < k; i++) {
            result = extractMax(copy);
        }

        return result;
    }

    private int extractMax(List<Integer> nums) {
        int max = nums.get(0);
        
        swap(nums, 0, nums.size() - 1);
        nums.remove(nums.size() - 1);
        if(!nums.isEmpty()) {
            heapify(nums, 0);
        }

        return max;
    }

    private void swap(int i, int j) {
        swap(nums, i, j);
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
