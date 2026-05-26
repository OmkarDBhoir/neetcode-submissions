class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] s = new int[temperatures.length];
        int top = -1;
        for(int i=temperatures.length-1; i>=0; i--) {
            while(top >= 0 && temperatures[s[top]] <= temperatures[i]) {
                top--;
            }
            result[i] = top >= 0 ? s[top] - i : 0;
            s[++top] = i;
        }       

        return result;
    }
}
