class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxFreq = 0;
        for(int i=0; i<tasks.length; i++) {
            int ind = tasks[i] - 'A';
            int freq = map.getOrDefault(ind, 0) + 1;
            map.put(ind, freq);
            maxFreq = Math.max(maxFreq, freq);
        }   
        int maxCount = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == maxFreq) maxCount++;
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
