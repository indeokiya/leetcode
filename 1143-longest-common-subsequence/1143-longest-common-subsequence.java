class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] dp = new int[len1];
        
        for (int i=0; i<len2; i++) {
            int max = 0;
            for (int j=0; j<len1; j++) {
                if (dp[j] > max) {
                    max = dp[j];
                } else if (text1.charAt(j) == text2.charAt(i)) {
                    dp[j] = max + 1;
                }
            }
        }
        
        int ret = 0;
        for (int j=0; j<len1; j++) {
            ret = Math.max(ret, dp[j]);
        }
        
        return ret;
    }
}