class Solution {
    private int[] memo;
    
    public int jump(int[] nums) {
//  O(n^2) dp
//         memo = new int[nums.length];
//         for (int i=nums.length-2; i>=0; i--) {
//             if (i+nums[i] >= nums.length-1) {
//                 memo[i] = 1;
//             } else {
//                 int limit = Math.min(i+nums[i], nums.length-2);
//                 memo[i] = Integer.MAX_VALUE;
//                 for (int j=i+1; j<=limit; j++) {
//                     if (memo[j] < 0) continue;
//                     memo[i] = Math.min(memo[i], memo[j]);
//                 }
//                 memo[i]++;
//             }
//         }
        
//         System.out.println(Arrays.toString(memo));
        
//         return memo[0];
        
// greedy
        
        int farthest = 0, currentReach = 0; 
        int count = 0;
        
        for (int i=0; i<nums.length-1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            
            if (i == currentReach) {
                count++;
                currentReach = farthest;
            }
        }
        
        return count;
    }
}