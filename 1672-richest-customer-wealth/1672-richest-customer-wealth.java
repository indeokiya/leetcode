class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int i=0; i<accounts.length; i++) {
            int tmp = 0;
            for (int j=0; j<accounts[0].length; j++) {
                tmp += accounts[i][j];
            }
            ans = ans > tmp ? ans : tmp;
        }
        return ans;
    }
}