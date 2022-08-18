class Solution {
    private int[] memo;
    
    public int jump(int[] nums) {
        memo = new int[nums.length];
        for (int i=nums.length-2; i>=0; i--) {
            if (i+nums[i] >= nums.length-1) {
                memo[i] = 1;
            } else {
                int limit = Math.min(i+nums[i], nums.length-2);
                memo[i] = Integer.MAX_VALUE;
                for (int j=i+1; j<=limit; j++) {
                    if (memo[j] < 0) continue;
                    memo[i] = Math.min(memo[i], memo[j]);
                }
                memo[i]++;
            }
        }
        
        System.out.println(Arrays.toString(memo));
        
        return memo[0];
    }
}