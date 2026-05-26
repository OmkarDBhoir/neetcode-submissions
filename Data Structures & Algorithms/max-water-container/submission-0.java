class Solution {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length - 1, max = 0;
        while(start < end) {
            int width = end - start;
            int height = Math.min(heights[start], heights[end]);
            max = Math.max(max, width * height);
            if(heights[start] <= heights[end]) start++;
            else end--;
        }

        return max;
    }
}
