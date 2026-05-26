class Solution {
    public int lastStoneWeight(int[] stones) {
        for(int i=0; i<stones.length; i++) {
            int size = stones.length - i;
            maxHeap(stones, size);
            int end = size-1;
            if(size == 2) {
                stones[0] = Math.abs(stones[0] - stones[1]);
                stones[1] = stones[0];
                swap(stones, 0, end);
            }  else if(size > 2) {
                int largest = stones[1] > stones[2] ? 1 : 2;
                stones[0] = Math.abs(stones[0] - stones[largest]);
                stones[largest] = stones[0];
                swap(stones, 0, end);
            }
        }
        return stones[0];
    }

    public void maxHeap(int[] stones, int n) {
        for(int i=n/2-1; i>=0; i--) {
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
