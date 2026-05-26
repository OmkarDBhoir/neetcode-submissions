class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int prev = 0, curr = 0;
        int i = 0, j = 0, n = nums1.length + nums2.length, k = n / 2;
        while(i < nums1.length && j < nums2.length && k >= 0) {
            prev = curr;
            if(nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            } else { 
                curr = nums2[j++];
            }
            k--;
        }

        while(k >= 0 && i < nums1.length) {
            prev = curr;
            curr = nums1[i++];
            k--;
        }

        while(k >= 0 && j < nums2.length) {
            prev = curr;
            curr = nums2[j++];
            k--;
        }

        return n % 2 == 0 ? (prev + curr) / 2.0D : (double) curr;
    }
}
