class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int i=0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int right = 0; right < nums.length; right++) {
            if(!q.isEmpty() && q.peekFirst() <= right - k) q.pollFirst();
            while(!q.isEmpty() && nums[right] >= nums[q.peekLast()]) q.pollLast();
            q.offerLast(right);
            if(right >= k - 1)ans[i++] = nums[q.peekFirst()];
        }
        return ans;
    }
}
