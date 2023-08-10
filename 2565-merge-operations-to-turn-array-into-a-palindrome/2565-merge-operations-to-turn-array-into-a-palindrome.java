class Solution {
    public int minimumOperations(int[] nums) {
        int p1 = 0, p2 = nums.length-1;
        int cnt = 0;

        while (p1 < p2) {
            if (nums[p1] == nums[p2]) {
                ++p1;
                --p2;
                continue;
            }
            cnt++;
            if (nums[p1] < nums[p2]) {
                nums[p1+1] += nums[p1];
                p1++;
                continue;
            }
            nums[p2-1] += nums[p2];
            p2--;
        }

        return cnt;
    }
}