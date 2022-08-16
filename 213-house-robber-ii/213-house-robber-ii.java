class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int curr, prev;
        prev = 0;
        curr = nums[nums.length-1];
        
        for (int i=nums.length-2; i>=1; --i) {
            int tmp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = tmp;
        }
        
        int ans1 = curr;
        
        prev = 0;
        curr = nums[nums.length-2];
        
        for (int i=nums.length-3; i>=0; --i) {
            int tmp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = tmp;            
        }
        
        int ans2 = curr;
        return Math.max(ans1, ans2);
    }
}