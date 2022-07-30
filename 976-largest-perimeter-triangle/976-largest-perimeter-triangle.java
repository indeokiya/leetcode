class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length-1; i>=2; i--) {
            for (int j = i-1; j>=1; j--) {
                for (int k = j-1; k>=0; k--) {
                    if (nums[k] + nums[j] > nums[i]) {
                        return nums[k] + nums[j] + nums[i];
                    } else{
                        break;
                    }
                }
            }
        }
        return 0;
    }
}