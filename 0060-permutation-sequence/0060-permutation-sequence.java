class Solution {
    private int[] factorials;
    private StringBuilder sb;

    public String getPermutation(int n, int k) {
        factorials = new int[10];
        factorials[0] = 1;
        for (int N=1, i=1; i<=9; i++) {
            N *= i;
            factorials[i] = N;
        }
        sb = new StringBuilder();

        helper(n, k, (1<<(n+1))-2);

        return sb.toString();
    }

    private void helper(int n, int k, int mask) {
        if (n == 0) {
            return;
        }
        n--;
        int target = (int)Math.ceil((double)k / factorials[n]);
        k -= factorials[n] * (target-1);

        for (int p=1, count=0; p<32; p++) {
            if (((1<<p) & mask) > 0) {
                count++;
                if (count == target) {
                    sb.append(String.valueOf(p));
                    helper(n, k, mask ^ (1<<p));
                    break;
                }
            }

        }
    }
}