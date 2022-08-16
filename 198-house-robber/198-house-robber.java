class Solution {
    public int rob(int[] nums) {
        int curr, prev;
        prev = 0;
        curr = nums[nums.length-1];
        
        for (int i=nums.length-2; i>=0; i--) {
            int tmp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = tmp;
        }
        
        return curr;
    }
}