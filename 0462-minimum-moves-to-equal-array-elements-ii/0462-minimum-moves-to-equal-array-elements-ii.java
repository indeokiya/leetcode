class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, sum = 0;
        while (l < r) {
            sum += nums[r--] - nums[l++];
        }
        return sum;
    }
}