class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<=heights.length; i++) {
            int curr = i == heights.length ? 0 : heights[i];
            while(!s.isEmpty() && heights[s.peek()] >= curr) {
                int height = heights[s.pop()];
                int widht = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, height * widht);
            }
            s.push(i);
        }

        return max;
    }
}
