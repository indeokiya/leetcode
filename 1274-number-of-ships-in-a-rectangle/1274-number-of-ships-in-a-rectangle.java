/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    private int ans = 0;
    
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        
        solve(sea, topRight, bottomLeft);   
        
        return ans;
    }
    
    public void solve(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1]) {
            return;
        }
        
        if (!sea.hasShips(topRight, bottomLeft)) {
            return;
        }
        
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            ans++;
            return;
        }
        
        int midX = (bottomLeft[0] + topRight[0]) >> 1;
        int midY = (bottomLeft[1] + topRight[1]) >> 1;
        
        solve(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY+1});
        solve(sea, topRight, new int[]{midX+1, midY+1});
        solve(sea, new int[]{midX, midY}, bottomLeft);
        solve(sea, new int[]{topRight[0], midY}, new int[]{midX+1, bottomLeft[1]});
    }
}


/*              bottomLeft x y          topRight x y
top left        bottomLeft[0], midY+1   midX, topRight[1]
top right       midX+1, midY+1          topRight
bottom left     bottomLeft              midX, midY
bottom right    midX+1, bottomLeft[1]   topRight[0], midY

midX = (bottomLeft[0] + topRight[0]) >> 1
midY = (bottomLeft[1] + topRight[1]) >> 1


*/