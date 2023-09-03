class Solution {
    public boolean confusingNumber(int n) {
        int original = n;
        int reversed = 0;
        boolean[] isValid = new boolean[]{true, true, false, false, false, false, true, false, true, true};
        int[] reverse = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        while (n > 0) {
            if (!isValid[n%10]) return false;
            reversed *= 10;
            reversed += reverse[n%10];
            n /= 10;
        }
        return reversed != original;
    }
}