class Solution {
    public int maxSubArray(int[] nums) {
        //
        int previous_sum = Integer.MIN_VALUE;
        int candidate = 0;
        for (int num: nums) {
            candidate += num;
            if (candidate > previous_sum) {
                previous_sum = candidate;
            }
            if (candidate < 0) {
                candidate = 0;
            }
        }
        // for (int i=0; i<nums.length; i++) {
        //     candidate += nums[i];
        //     if (candidate > previous_sum) {
        //         previous_sum = candidate;
        //     }
        //     if (candidate < 0) {
        //         candidate = 0;
        //     }
        // }
        return previous_sum;
    }
}