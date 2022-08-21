class Solution {
    public int checkRow(int i, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags, int n) {
        if (i == n) return 1;
        
        int count = 0;
        
        for (int j=0; j<n; j++) {
            if (cols.contains(j) || diags.contains(i-j) || antiDiags.contains(i+j)) {
                continue;
            } 
        
            cols.add(j); diags.add(i-j); antiDiags.add(i+j);
            count += checkRow(i+1, cols, diags, antiDiags, n);
            cols.remove(j); diags.remove(i-j); antiDiags.remove(i+j);
        }
        
        return count;
    }
    
    public int totalNQueens(int n) {
        return checkRow(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
    }
}