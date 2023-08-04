class Solution {
    private final double E = 1e-5;

    public boolean checkContradictions(List<List<String>> equations, double[] values) {        
        final int N = values.length;
        Map<String, Integer> map = new HashMap<>();
        UF uf = new UF(N);
    
        for (int i=0; i<N; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map.putIfAbsent(a, map.size());
            map.putIfAbsent(b, map.size());
            int num1 = map.get(a);
            int num2 = map.get(b);
            int root1 = uf.find(num1);
            int root2 = uf.find(num2);
        
            if (root1 == root2) {
                if (uf.merge(num1, num2, values[i])) {
                    return true;
                }
            } else {
                uf.merge(num1, num2, values[i]);
            }
        }

        return false;
    }

    private class UF {
        int[] uf;
        double[] weight;

        UF(int n) {
            uf = IntStream.range(0, 2*n).toArray();
            weight = new double[2*n];
            Arrays.fill(weight, 1);
        }

        private int find(int n) {
            if (n == uf[n]) {
                return n;
            }
            int root = find(uf[n]);
            weight[n] *= weight[uf[n]];
            uf[n] = root;
            return uf[n];
        }

        private boolean merge(int a, int b, double val) {
            int rootA = uf[a];
            int rootB = uf[b];
            if (rootA == rootB) {
                return Math.abs(weight[b]/weight[a] - val) >= E;
            }
            if (rootB != b) {
                weight[rootB] = 1/weight[b];
                uf[rootB] = b;
            }
            uf[b] = a;
            weight[b] = val;
            return false;
        }
    }
}