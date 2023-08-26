class Solution {
    public int minimumSwaps(int[] nums) {
        int N = nums.length;
        int minIdx = N;
        int minVal = 1000000;
        for (int i=N-1; i>=0; i--) {
            if (nums[i] <= minVal) {
                minIdx = i;
                minVal = nums[i];
            }
        }

        int maxIdx = -1;
        int maxVal = -1;
        for (int i=0; i<N; i++) {
            if (nums[i] >= maxVal) {
                maxIdx = i;
                maxVal = nums[i];
            }
        }

        return minIdx > maxIdx ? minIdx + (N-1-maxIdx) - 1 : minIdx + (N-1-maxIdx);
    }
}