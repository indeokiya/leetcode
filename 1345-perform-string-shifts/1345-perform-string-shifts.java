class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = 0;
        for (int[] move : shift) {
            n += (1-2*move[0]) * move[1];
        }
        n = (n + shift.length * 100 * s.length()) % s.length();

        return s.substring(n) + s.substring(0, n);
    }
}