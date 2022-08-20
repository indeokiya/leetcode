class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        
        int ans = 0, count = 1;
        int prev = nums[1]-nums[0];
        int curr;
        for (int i=2; i<nums.length; i++) {
            curr = nums[i]-nums[i-1];
            if (curr == prev) {
                count++;
            } else {
                if (count>=2) {
                    ans += (count)*(count-1)/2;
                } 
                count = 1;
                prev = curr;
            }
        }
        
        if (count>=2) {
            ans += (count)*(count-1)/2;
        } 
        
        return ans;
    }
}

// n n-1 n-2 ... 3
// 1 2 ....      n-2
//     (n-2)(n-1)/2

