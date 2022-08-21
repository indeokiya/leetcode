class Solution {
    private HashSet<Integer> cols, diags, antiDiags;
    private int count;
    private int n;
    
    public void checkRow(int i) {
        for (int j=0; j<n; j++) {
            if (cols.contains(j) || diags.contains(i-j) || antiDiags.contains(i+j)) {
                continue;
            } else {
                if (i==n-1) {
                    count++;
                } else {
                    cols.add(j); diags.add(i-j); antiDiags.add(i+j);
                    checkRow(i+1);
                    cols.remove(j); diags.remove(i-j); antiDiags.remove(i+j);
                }
            }
        }
    }
    
//     public void placeQueen(int i, int j) {
//         for (int k=0; k<n; k++) {
//             attacks[k][j] += 1;
//             attacks[i][k] += 1;
//             if (i-j+k>=0 && i-j+k<n) attacks[i-j+k][k] += 1; 
//             if (i+j-k>=0 && i+j-k<n) attacks[i+j-k][k] += 1;
//         }
//         attacks[i][j] -= 3;
//     }
    
//     public void removeQueen(int i, int j) {
//         for (int k=0; k<n; k++) {
//             attacks[k][j] -= 1;
//             attacks[i][k] -= 1;
//             if (i-j+k>=0 && i-j+k<n) attacks[i-j+k][k] -= 1; 
//             if (i+j-k>=0 && i+j-k<n) attacks[i+j-k][k] -= 1;
//         }
//         attacks[i][j] += 3;        
//     }
    
    public int totalNQueens(int n) {
        count = 0;
        this.n = n;
        cols = new HashSet<>();
        diags = new HashSet<>();
        antiDiags = new HashSet<>();

        checkRow(0);

        return count; 
    }
}