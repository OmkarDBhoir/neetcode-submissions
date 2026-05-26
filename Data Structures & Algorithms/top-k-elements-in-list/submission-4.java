class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: map.keySet()) {
            int f = map.get(key);
            if(bucket[f] == null) bucket[f] = new ArrayList<Integer>();
            bucket[f].add(key);
        }
        int j = 0;
        for(int i=bucket.length-1; i>=0 && j < k; i--) {
            if(bucket[i] != null) {
                for(int num: bucket[i]) {
                    result[j++] = num;
                    if(j == k) break;
                }
            }
        }
        return result;
    }
}
