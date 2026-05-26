class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for(int right = 0; right <= heights.length; right++) {
            int curr = right == heights.length ? 0 : heights[right];
            while(!s.isEmpty() && heights[s.peek()] >= curr) {
                int height = heights[s.pop()];
                int width = s.isEmpty() ? right : right - s.peek() - 1;
                max = Math.max(max, height * width);
            }
            s.push(right);
        }

        return max;
    }
}
