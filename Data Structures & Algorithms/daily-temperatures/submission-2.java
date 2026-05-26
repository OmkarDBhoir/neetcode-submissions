class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] s = new int[temperatures.length];
        int top = -1;
        for(int i=0; i<temperatures.length; i++) {
            while(top > -1 && temperatures[s[top]] < temperatures[i]) {
                result[s[top]] = i - s[top--];
            }
            s[++top]  = i;
        }

        return result;
    }
}
