class Solution {
    public int search(int[] nums, int target) {
        // aviod recursion;
        int left = 0, right = nums.length-1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] < target) {
                left = mid+1;
                mid = (left + right) / 2;
            } else if (nums[mid] > target) {
                right = mid-1;
                mid = (left + right) / 2;
            } else {
                return mid;
            }
        }
        return nums[mid] == target ? mid : -1;
    }
}