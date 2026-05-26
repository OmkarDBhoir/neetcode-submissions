class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int last = height.length-1;
        prefix[0] = height[0];
        suffix[last] = height[last];
        for(int i=1; i<height.length; i++) {
            prefix[i] = Math.max(height[i], prefix[i-1]);
            suffix[last - i] = Math.max(height[last - i], suffix[last - i + 1]);
        } 
        int left = 0, right = height.length-1;
        int water = 0;
        for(int i=0; i<height.length; i++) {
            water += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return water;
    }
}
