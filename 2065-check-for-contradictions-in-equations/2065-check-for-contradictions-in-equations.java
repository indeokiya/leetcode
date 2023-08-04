class Solution {
    private Map<String, Integer> map;
    private int[] uf;
    private double[] weight;
    private final double E = 1e-5;

    public boolean checkContradictions(List<List<String>> equations, double[] values) {        
        map = new HashMap<>();
        uf = IntStream.range(0, 200).toArray();
        weight = new double[200];
        Arrays.fill(weight, 1);
    
        for (int i=0, idx=0; i<values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!map.containsKey(a)) {
                map.put(a, idx++);
            }
            if (!map.containsKey(b)) {
                map.put(b, idx++);
            }
            int num1 = map.get(a);
            int num2 = map.get(b);
            int root1 = find(num1);
            int root2 = find(num2);
            System.out.println("num1: " + num1 + ", root1: " + root1 + ", num2: " + num2 + ", root2: " + root2);
            System.out.println("weight " + a + ": " + weight[num1] + ", weight " + b + ": " + weight[num2]);
            if (root1 == root2) {
                if (Math.abs(weight[num2]/weight[num1] - values[i]) >= E) {
                    return true;
                }
            } else {
                merge(num1, num2, values[i]);
            }
            System.out.println("weight 1: " + weight[num1] + ", weight 2: " + weight[num2]);
        }

        return false;
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

    private void merge(int a, int b, double val) {
        if (find(b) != b) {
            weight[find(b)] = 1/weight[b];
            uf[find(b)] = b;
        }
        uf[b] = a;
        weight[b] = val;
    }
}