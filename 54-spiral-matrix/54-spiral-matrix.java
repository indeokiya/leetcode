class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int upper_bound = 0, lower_bound = m-1, left_bound = 0, right_bound = n-1;
        int num = 0;
        
        while (true) {
            if (left_bound == right_bound && upper_bound == lower_bound) {
                ans.add(matrix[upper_bound][upper_bound]);
                if (++num == m*n) return ans;
            }
            for (int j=left_bound; j<right_bound; j++) {
                ans.add(matrix[upper_bound][j]);
                // System.out.println(ans.size());
                if (++num == m*n) return ans;
            }

            for (int i=upper_bound; i<lower_bound; i++) {
                ans.add(matrix[i][right_bound]);
                                // System.out.println(ans.size());
                if (++num == m*n) return ans;
            }
            
            for (int j=right_bound; j>left_bound; j--) {
                ans.add(matrix[lower_bound][j]);
                                // System.out.println(ans.size());
                if (++num == m*n) return ans;   
            }
            
            for (int i=lower_bound; i>upper_bound; i--) {
                ans.add(matrix[i][left_bound]);
                                // System.out.println(ans.size());
                if (++num == m*n) return ans;   
            }
            upper_bound++;
            right_bound--;
            lower_bound--;
            left_bound++;
        }
    }
}