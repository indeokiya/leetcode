class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] mapping = new int[nums1.length];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
            m.put(nums2[i], i);
        }
        for (int i=0; i<nums1.length; i++) {
            mapping[i] = m.get(nums1[i]);
        }

        return mapping;    
    }
}