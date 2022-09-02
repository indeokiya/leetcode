class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int n = nums1.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                m.put(nums1[i]+nums2[j], m.getOrDefault(nums1[i]+nums2[j], 0)+1);
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (m.containsKey(-nums3[i]-nums4[j])) {
                    ans += m.get(-nums3[i]-nums4[j]);
                }
            }
        }
        return ans;
    }
}