class Solution {
    public boolean isArmstrong(int n) {
        long sum = 0;
        int original = n;
        int size = (int) Math.log10(n) + 1;

        while (n > 0) {
            sum += Math.pow(n%10, size);
            if (sum > Integer.MAX_VALUE) {
                return false;
            }
            n /= 10;
        }
        return sum == original;
    }
}