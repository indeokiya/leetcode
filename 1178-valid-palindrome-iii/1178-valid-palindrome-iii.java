class Solution {
    private int[][] memo;

    public boolean isValidPalindrome(String s, int k) {
        memo = new int[s.length()][s.length()];

        for (int i=s.length()-2; i>=0; i--) {
            for (int j=i+1; j<s.length(); j++) {
                memo[i][j] = s.charAt(i) == s.charAt(j)
                    ? memo[i+1][j-1]
                    : 1 + Math.min(memo[i+1][j], memo[i][j-1]);
            }
        }

        return memo[0][s.length()-1] <= k;
    }
}

/*

0   ?   ?   ?
    0   ?   ?
        0   ?
            0


*/

