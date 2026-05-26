class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++) {
            int j = i+1;
            while(j < temperatures.length && temperatures[j] <= temperatures[i]) j++;
            if(j == temperatures.length) result[i] = 0;
            else result[i] = j - i;
        }   

        return result;
    }
}
