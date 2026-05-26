class Solution {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length - 1, max = 0;
        for(int i=0; i<heights.length-1; i++) {
            for(int j=i+1; j<heights.length; j++) {
                max = Math.max(max, Math.min(heights[i], heights[j]) * (j - i));
            }
        }

        return max;
    }
}
