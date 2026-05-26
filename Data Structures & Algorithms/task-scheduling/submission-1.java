class Solution {
    public int leastInterval(char[] tasks, int n) {
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>(Collections.reverseOrder());
        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int maxFreq = 0;
        for(Integer i: map.values()) {
            maxFreq = Math.max(maxFreq, i);
        }
        int maxCount = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxFreq) {
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxFreq-1) * (n+1) + maxCount);
    }
}
