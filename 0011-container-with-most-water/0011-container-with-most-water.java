class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = -1;

        while (l < r) {
            int W = r - l;
            int H = Math.min(height[l], height[r]);
            if (max < W*H) max = W*H;
            for (; l<r && height[l] <= H; l++) {}
            for (; l<r && height[r] <= H; r--) {}
        }

        return max;
    }
}