class Solution {
    public void moveZeroes(int[] nums) {
        //int countZero = 0;
        int indexZero = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[indexZero++] = nums[i];
            }
        }
        
        for (int i = indexZero; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}