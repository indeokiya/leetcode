class Solution {
    private int[][] count;
    private String s;

    public boolean isValidPalindrome(String s, int k) {
        this.s = s;
        count = new int[s.length()+1][s.length()+1];
        for (int i=0; i<=s.length(); i++) {
            Arrays.fill(count[i], -1);
        }

        return helper(0, s.length()-1, k);
    }

    public boolean helper(int l, int r, int k) {
        if (count[l][r] >= k) {
            return false;
        }
        count[l][r] = k;

        while (l<r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }

            if (k==0) return false;
            return helper(l, r-1, k-1) || helper(l+1, r, k-1);
        }
        return true;
    }
}