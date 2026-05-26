class Solution {
    public int trap(int[] height) {
        int[] preFix = new int[height.length];
        int[] sufFix = new int[height.length];
        int total = 0;
        preFix[0] = height[0];
        sufFix[height.length-1] = height[height.length-1];
        for(int i=1; i<height.length; i++) {
            preFix[i] = Math.max(height[i], preFix[i-1]);
        }
        for(int i=height.length-2;  i>=0; i--) {
            sufFix[i] = Math.max(height[i], sufFix[i+1]);
        }

        for(int i=0; i<height.length; i++) {
            total += Math.min(preFix[i], sufFix[i]) - height[i];
        }    

        return total;    
    }
}
