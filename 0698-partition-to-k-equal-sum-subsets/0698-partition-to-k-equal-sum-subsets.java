class Solution {
    private int SUM;
    private int[] subset;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        SUM = Arrays.stream(nums).sum();
        if (SUM % k != 0) return false;
        
        SUM /= k;
        subset = new int[k];

        Arrays.sort(nums);
        // nums = Arrays.stream(nums).boxed()
        //             .sorted(Collections.reverseOrder())
        //             .mapToInt(Integer::intValue)
        //             .toArray();

        return backtracking(nums, nums.length, k, nums.length-1);
    }

    private boolean backtracking(int[] nums, int N, int K, int step) {
        if (step == -1) return true;

        for (int i=0; i<K; i++) {
            if (subset[i] + nums[step] > SUM) continue;
            subset[i] += nums[step];
            if (backtracking(nums, N, K, step-1)) return true;
            subset[i] -= nums[step];
            if (subset[i] == 0) break;
        }

        return false;
    }
}