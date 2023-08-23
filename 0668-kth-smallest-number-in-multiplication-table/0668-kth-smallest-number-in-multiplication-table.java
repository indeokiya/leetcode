class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo=0, hi=m*n;
        while (lo+1 < hi) {
            int mid = (lo + hi) >> 1;
            if (count(mid, m, n) < k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    private int count(int mid, int m, int n) {
        int cnt = 0;
        for (int i=1; i<=m; i++) {
            cnt += Math.min(n, mid/i);
        }
        return cnt;
    }
}

/*

find minimum integer i such that COUNT(element <= i) >= k
init: lo=0, hi=m*n
[1, 2, ..., i-1], [i, i+1, ..., m*n]
              lo   hi

answer: hi

*/