class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int d = (arr[n-1] - arr[0]) / n;
        int lo = 0, hi = n-1;

        while (lo+1 < hi) {
            int mid = (lo+hi) >> 1;
            if ((arr[mid] - arr[lo]) != (mid - lo) * d) {
                hi = mid;
            } else {
                lo = mid;
            }

        }

        return arr[lo] + d;
    }
}


/*
lo              mid          hi
0, 1, ..., i-1, i, i+1, ..., n-1,

*/