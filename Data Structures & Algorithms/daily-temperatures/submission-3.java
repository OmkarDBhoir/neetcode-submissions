class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i=temperatures.length-1; i>=0; i--) {
            while(!q.isEmpty() && temperatures[q.peekLast()] <= temperatures[i]) q.pollLast();
            result[i] = q.isEmpty() ? 0 : q.peekLast() - i;
            q.offerLast(i); 
        }   

        return result;
    }
}
