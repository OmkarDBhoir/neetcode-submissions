class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i=0; i<temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int ind = s.pop();
                result[ind] = i - ind;
            }
            s.push(i);
        }

        return result;
    }
}
