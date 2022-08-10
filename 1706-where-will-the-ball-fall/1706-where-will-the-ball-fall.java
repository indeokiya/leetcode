class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        
        for (int iter1=0; iter1<n; iter1++) {
            int i=0;
            int j=iter1;
            boolean isUpper = true; //if upper side
            
            while(i<m) {
                if (isUpper == true && grid[i][j] == 1) {
                    if (j+1 >= n || grid[i][j+1] == -1) break;
                    j++;
                    isUpper = false;
                } else if (isUpper == true && grid[i][j] == -1) {
                    if (j <= 0 || grid[i][j-1] == 1) break;
                    j--;
                    isUpper = false;
                } else if (isUpper == false && grid[i][j] == 1) {
                    isUpper = true;
                    i++;
                } else if (isUpper == false && grid[i][j] == -1) {
                    isUpper = true;
                    i++;
                }
            }
            
            ans[iter1] = i==m ? j : -1;
        }
        
        return ans;
    }
}