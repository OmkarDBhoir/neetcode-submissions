class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> q  = new ArrayDeque<Integer>();
        int left = 0, i = 0;
        for(int right = 0; right<nums.length; right++) {
            if(!q.isEmpty() && q.peekFirst() <= right - k) q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[right]) q.pollLast();
            q.offerLast(right);
            if(right >= k-1) ans[i++] = nums[q.peekFirst()];
        }

        return ans;
    }
}
