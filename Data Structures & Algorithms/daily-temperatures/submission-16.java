class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for(int i=temperatures.length-1; i>=0; i--) {
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            result[i] = !s.isEmpty() ? s.peek() - i : 0;
            s.push(i);
        }       

        return result;
    }
}
