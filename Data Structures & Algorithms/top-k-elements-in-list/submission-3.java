class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            q.offer(e);
            if(q.size() > k) q.poll();
        }
        int i = 0;
        while(!q.isEmpty() && i < k) {
            result[i++] = q.poll().getKey();
        }
        return result;
    }
}
