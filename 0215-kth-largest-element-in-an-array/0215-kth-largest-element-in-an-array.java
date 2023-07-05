class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num); 
        }
        
        int[] counts = new int[max-min+1];
        for (int num : nums) {
            counts[num-min]++;
        }
        
        for (int n=max-min; n>=0; n--) {
            k -= counts[n];
            if (k<=0) {
                return n+min;
            }
        }
        
        return 0;
    }
}