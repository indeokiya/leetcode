class Solution {
    public void wiggleSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[max+1];
        for (int num : nums)
            counts[num]++;

        int p = max;
        for (int i=1; i<nums.length; i+=2) {
            while (counts[p] == 0) p--;
            counts[p]--;
            nums[i] = p;
        }

        for (int i=0; i<nums.length; i+=2) {
            while (counts[p] == 0) p--;
            counts[p]--;
            nums[i] = p;
        }


    }
}