class Solution {
    public int trap(int[] height) {
        int total = 0;
        for(int i=0; i<height.length; i++) {
            int left = i-1, right = i+1;
            int leftMax = 0, rightMax =  0, water = 0;
            while(left >= 0) leftMax = Math.max(height[left--], leftMax);
            while(right < height.length) rightMax = Math.max(height[right++], rightMax);
            if(leftMax <= rightMax) {
                water = leftMax - height[i];
            } else {
                water = rightMax - height[i];
            }

            if(water > 0) total += water;
        }

        return total;
    }
}
