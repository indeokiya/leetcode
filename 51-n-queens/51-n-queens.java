class Solution {
    private boolean[] cols, diags, antiDiags;
    private List<List<String>> ans;
    private char[][] chars;
    
    public void checkRow(int i, int n) {
        if (i == n) {
            LinkedList<String> s = new LinkedList<String>();
            
            for (char[] c : chars) {
                s.add(new String(c));
            }
            
            ans.add(s);
        }
        
        for (int j=0; j<n; j++) {
            int diag = i-j+n;
            int antiDiag = i+j;
            
            if (cols[j] || diags[diag] || antiDiags[antiDiag]) continue;
            
            cols[j] = true; diags[diag] = true; antiDiags[antiDiag] = true; chars[i][j] = 'Q';
            checkRow(i+1, n);
            cols[j] = false; diags[diag] = false; antiDiags[antiDiag] = false; chars[i][j] = '.';
        }
    }    
    
    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diags = new boolean[2*n]; // i-j+n == const
        antiDiags = new boolean[2*n]; // i+j == const       
        ans = new LinkedList<>();
        chars = new char[n][n];
        for (char[] c : chars) {
            Arrays.fill(c, '.');
        }
        
        checkRow(0, n);
        
        return ans;
    }
}