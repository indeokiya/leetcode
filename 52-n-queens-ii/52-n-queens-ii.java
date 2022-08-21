class Solution {
    private int[][] attacks;
    private int count;
    private int n;
    
    public boolean isPlaceable(int i, int j) {
        return attacks[i][j] == 0;
    }
    
    public void checkRow(int i) {
        for (int j=0; j<n; j++) {
            if (isPlaceable(i, j)) {
                if (i==n-1) {
                    count++;
                } else {
                    placeQueen(i, j);    //when to delete?
                    checkRow(i+1);                    
                    removeQueen(i, j);
                }
            }
        }
    }
    
    public void placeQueen(int i, int j) {
        for (int k=0; k<n; k++) {
            attacks[k][j] += 1;
            attacks[i][k] += 1;
            if (i-j+k>=0 && i-j+k<n) attacks[i-j+k][k] += 1; 
            if (i+j-k>=0 && i+j-k<n) attacks[i+j-k][k] += 1;
        }
        attacks[i][j] -= 3;
    }
    
    public void removeQueen(int i, int j) {
        for (int k=0; k<n; k++) {
            attacks[k][j] -= 1;
            attacks[i][k] -= 1;
            if (i-j+k>=0 && i-j+k<n) attacks[i-j+k][k] -= 1; 
            if (i+j-k>=0 && i+j-k<n) attacks[i+j-k][k] -= 1;
        }
        attacks[i][j] += 3;        
    }
    
    public int totalNQueens(int n) {
        count = 0;
        this.n = n;
        attacks = new int[n][n];

        checkRow(0);

        return count; 
    }
}