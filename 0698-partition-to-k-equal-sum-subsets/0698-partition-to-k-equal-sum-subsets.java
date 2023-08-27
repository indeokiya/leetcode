class Solution {
    private int SUM;
    private int[] subset;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int arrSum = Arrays.stream(nums).sum();
        if (arrSum % k != 0) return false;
        
        this.SUM = arrSum / k;
        this.subset = new int[k];

        nums = Arrays.stream(nums).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

        return backtracking(nums, nums.length, k, 0);
    }

    private boolean backtracking(int[] nums, int N, int K, int step) {
        if (step == N) return true;

        for (int i=0; i<K; i++) {
            if (subset[i] + nums[step] > SUM) continue;
            subset[i] += nums[step];
            if (backtracking(nums, N, K, step+1)) return true;
            subset[i] -= nums[step];
            if (subset[i] == 0) break;
        }

        return false;
    }
}