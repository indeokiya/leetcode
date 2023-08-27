class Solution {
    private int N;

    public boolean canCross(int[] stones) {
        this.N = stones.length;
        if (stones[1] != 1 || stones[N-1] > N*(N-1)/2) return false;
        
        boolean[][] reach = new boolean[N][N];
        reach[0][1] = true;
        Map<Integer, Integer> _stones = new HashMap<>();
        for (int i=1; i<N; i++) _stones.put(stones[i], i);

        for (int j=1; j<N-1; j++) {
            for (int i=j-1; i>=0; i--) {
                if (!reach[i][j]) {
                    continue;
                }
                int nextStep = 2*stones[j] - stones[i];
                for (int d=-1; d<=1; d++) {
                    if (!_stones.containsKey(nextStep + d)) {
                        continue;
                    }
                    reach[j][_stones.get(nextStep + d)] = true;
                }
            }
        }


        for (int i=N-2; i>=0; i--) if (reach[i][N-1]) return true;
        return false;
    }
}

/*
for each index j from 2 to N-2:
    check index i where i < j && reach[i][j] = true
    if found i, then avaliable next step is stones[j] + (stone[j] - stone[i]) + (-1...1) 
    if exists next step k, then reach[j][k] = true


F   T   F   F
    F   T   T   F   F
        F   T   T   
            F
                F
                    F
                        F


*/