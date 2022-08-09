public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        int mask = 1<<31;
        while (mask != 0) {
            if ((mask & n) != 0) {
                ans += 1;
            }
            
            mask = mask >>> 1;
        }
        return ans;
        
    }
}