class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int start=0, count=0; count<nums.length; start++) {
            int curr = start;
            int prev = nums[start];
            do {
                int next = (curr + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                curr = next;
                prev = tmp;
                count++;
            } while (curr != start);
        }
    }
    

}