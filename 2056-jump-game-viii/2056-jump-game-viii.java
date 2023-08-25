class Solution {
    public long minCost(int[] nums, int[] costs) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        // long[] dp = new long[nums.length];
        long[] dp = new long[nums.length];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i=0; i<nums.length; i++) {
            while (!s1.isEmpty() && nums[s1.peekLast()] <= nums[i]) {
                dp[i] = Math.min(dp[i], dp[s1.pollLast()] + costs[i]);
            }

            while(!s2.isEmpty() && nums[s2.peekLast()] > nums[i]) {
                dp[i] = Math.min(dp[i], dp[s2.pollLast()] + costs[i]);
            }

            s1.offerLast(i);
            s2.offerLast(i);
        }

        return dp[nums.length-1];
    }
}

/*

for integer i:



if nums[s1.peekLast()] > nums[i]:
    just push nums[i]
else:
    dp[i] = min(dp[i], dp[peek] + costs[i]) 
    poll;

    push nums[i]    

dp[i] = dp[s1.pollLast()] + costs[i];



*/