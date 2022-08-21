class Solution {
    private boolean[] cols, diags, antiDiags;
    private int count;
    
    public void checkRow(int i, int n) {
        if (i == n) {
            count++;
            return;
        }
        
        for (int j=0; j<n; j++) {
            int diag = i-j+n;
            int antiDiag = i+j;
            
            if (cols[j] || diags[diag] || antiDiags[antiDiag]) continue;
            
            cols[j] = true; diags[diag] = true; antiDiags[antiDiag] = true;
            checkRow(i+1, n);
            cols[j] = false; diags[diag] = false; antiDiags[antiDiag] = false;
        }
    }
    
    public int totalNQueens(int n) {
        count = 0;

        cols = new boolean[n];
        diags = new boolean[2*n]; // i-j+n == const
        antiDiags = new boolean[2*n]; // i+j == const

        checkRow(0, n);

        return count; 
    }
}