class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int n = nums1.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        
        int min = Math.min(nums1[0]+nums2[0], -nums3[n-1]-nums4[n-1]);
        int max = Math.max(nums1[n-1]+nums2[n-1], -nums3[0]-nums4[0]);
        int[] arr = new int[max-min+1];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[nums1[i]+nums2[j]-min]++;
            }
        }
        int ans=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans += arr[-nums3[i]-nums4[j]-min];
            }
        }
        return ans;
    }
}