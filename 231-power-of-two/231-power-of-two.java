class Solution {
    public boolean isPowerOfTwo(int n) {
        if ( n == Integer.MIN_VALUE ) return false;
        int mask = 1<<31;
        int count = 0;
        for (int i=0; i<32; i++) {
            if ((mask & n) != 0) {
                count++;
            }
            mask = mask >>> 1;
        }
        
        if (count == 1) return true;
        return false;
    }
}