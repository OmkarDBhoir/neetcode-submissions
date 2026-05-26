class Solution {
    public int leastInterval(char[] tasks, int n) {
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>(Collections.reverseOrder());
        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int maxFreq = map.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        int maxCount = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxFreq) {
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxFreq-1) * (n+1) + maxCount);
    }
}
