class Solution {
    private int[] memo;
    private int n;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        memo = new int[n+1];
        
        // for (int j=0; j<n; j++) {
        //     memo[j] = triangle.get(n-1).get(j);
        // }
        
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                memo[j] = triangle.get(i).get(j) + Math.min(memo[j], memo[j+1]);
            }
        }
        
        return memo[0];
    }
}


// 2
// 3 4
// 6 5 7
// 4 1 8 3