public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
        /*
            int ans = 0;
        while (n > 0) {
            System.out.println(n);
            n = n >> 1;
            
        }
        return ans;
        */
    }
}