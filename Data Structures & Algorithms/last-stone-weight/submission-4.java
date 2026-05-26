class Solution {
    public int lastStoneWeight(int[] stones) {
        maxHeap(stones, stones.length);
        int size = stones.length;
        while(size > 1) {
            int x = extractMax(stones, size);
            size--;
            int y = extractMax(stones, size);
            size--;
            if(x != y) {
                stones[size] = x - y;
                size++;
                siftUp(stones, size-1);
            }
        }
        return size == 1 ? stones[0] : 0;
    }

    public int extractMax(int[] stones, int size) {
        int max = stones[0];
        stones[0] = stones[size-1];
        heapify(stones, 0, size-1);
        return max;
    }

    public void siftUp(int[] arr, int i) {
        while(i > 0) {
            int parent = (i - 1) / 2;
            if(arr[i] < arr[parent]) break;
            swap(arr, i, parent);
            i = parent;
        }
    }

    public void maxHeap(int[] stones, int n) {
        for(int i=n/2 - 1; i>=0; i--) {
            heapify(stones, i, n);
        }
    }

    public void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, n);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
