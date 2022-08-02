class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        
        int mid = (left+right)/2;
        while (left != right-1) {
            if (nums[mid] < target) {
                left = mid;
                mid = (left+right)/2;
            } else if (nums[mid] > target) {
                right = mid;
                mid = (left+right)/2;
            } else {
                return mid;
            }
        }
        return right;
    }
}