class Solution {
    static int n;
    static int m;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        int[] nums3 = new int[n + m];
        int idx3 = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < n && idx2 < m) {
            if (nums1[idx1] < nums2[idx2]) {
                nums3[idx3++] = nums1[idx1++];
            } else {
                nums3[idx3++] = nums2[idx2++];
            }
        }

        while (idx1 < n) {
            nums3[idx3++] = nums1[idx1++];
        }

        while (idx2 < m) {
            nums3[idx3++] = nums2[idx2++];
        }

        int length = nums3.length;
        double mid = 0.0;
        if (length % 2 == 0) {
            mid = (nums3[length / 2] + nums3[length / 2 - 1]) / 2.0;
        } else {
            mid = (double) nums3[length / 2];
        }

        return mid;
        
    }
}