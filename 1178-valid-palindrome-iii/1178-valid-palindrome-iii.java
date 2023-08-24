class Solution {
    private int[] memo;

    public boolean isValidPalindrome(String s, int k) {
        memo = new int[s.length()];

        for (int i=s.length()-2; i>=0; i--) {
            int prev = 0;
            for (int j=i+1; j<s.length(); j++) {
                int tmp = memo[j];
                memo[j] = s.charAt(i) == s.charAt(j)
                    ? prev
                    : 1 + Math.min(memo[j], memo[j-1]);

                prev = tmp;
            }
        }

        return memo[s.length()-1] <= k;
    }
}

/*

0   ?   ?   ?
    0   ?   ?
        0   ?
            0


*/

