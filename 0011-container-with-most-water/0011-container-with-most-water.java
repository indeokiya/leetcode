class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = -1;
        while (l < r) {
            int width = r - l;
            max = Math.max(max, width * Math.min(height[l], height[r]));
            if (height[l] < height[r]) l++;
            else r--;
        }

        return max;
    }
}