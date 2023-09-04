class Solution {
    private int M, N;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.M = matrix.length;
        this.N = matrix[0].length;
        int R = getRow(matrix, target);
        if (R < 0) return false;
        int C = getCol(matrix[R], target);
        return matrix[R][C] == target;
    }

    private int getRow(int[][] matrix, int target) {
        int lo = -1, hi = M;
        while (lo+1 < hi) {
            int mid = (lo+hi) >> 1;
            if (matrix[mid][0] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private int getCol(int[] matrix, int target) {
        int lo = 0, hi = N;
        while (lo+1 < hi) {
            int mid = (lo+hi) >> 1;
            if (matrix[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return lo;
    }
}