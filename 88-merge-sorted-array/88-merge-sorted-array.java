class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        
        int p1 = m-1, p2 = n-1;
        for (int i=m+n-1; i>=0; i--) {
            if (p1 < 0) {
                nums1[i] = nums2[p2--];
                continue;
            } else if (p2 < 0) {
                break;
            }
            
            if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
    }
}