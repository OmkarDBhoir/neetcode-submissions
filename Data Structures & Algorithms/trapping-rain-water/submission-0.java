class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0, total = 0;
        while(left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax <= rightMax) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }

        return total;
    }
}
