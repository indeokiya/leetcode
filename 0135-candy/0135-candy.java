class Solution {
    int N;
    private int[] candies;

    public int candy(int[] ratings) {
        N = ratings.length;
        candies = new int[N];
        Arrays.fill(candies, 1);
        int ans = 0;

        for (int i=0; i<N-1; i++) {
            if (ratings[i+1] > ratings[i]) {
                candies[i+1] = candies[i] + 1;
            }
        }

        for (int i=N-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        for (int i=0; i<N; i++) {
            ans += candies[i];
        }

        return ans;
    }
}