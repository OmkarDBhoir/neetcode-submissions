class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(int i=0; i<tasks.length; i++) {
            int ind = tasks[i] - 'A';
            map[ind]++;
        }   
        Arrays.sort(map);
        int maxFreq = map[25];
        int maxCount = 1;
        for(int i=24; i>=0; i--) {
            if(map[i] == maxFreq) maxCount++;
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
