class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            q.offer(entry);
            if(q.size() > k) q.poll();
        }
        return q.stream().mapToInt(e -> e.getKey()).toArray();
    }
}
