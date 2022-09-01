class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCnt = 0;
        int zeroIdx = -1;
        int[] ans = new int[nums.length];
        int total = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
                zeroIdx = i;
                continue;
            }
            total *= nums[i];
        }
        
        if (zeroCnt>=2) {
            return ans;
        } else if (zeroCnt==1) {
            ans[zeroIdx] = total;
            return ans;
        } else {
            for (int i=0; i<nums.length; i++) {
                total /= nums[i];
                ans[i] = total;
                total *= nums[i];
            }
            return ans;
        }
    }
}