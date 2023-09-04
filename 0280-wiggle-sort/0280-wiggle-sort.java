class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length-1; i+=2) {
            swap(nums, i);
        }
    }

    private void swap(int[] nums, int i) {
        int tmp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = tmp;
    }
}