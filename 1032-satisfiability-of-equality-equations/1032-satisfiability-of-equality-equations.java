class Solution {
    private int[] uf = new int[26];
    private int find(int n) {
        if (uf[n] < 0) {
            return n;
        }
        uf[n] = find(uf[n]);
        return uf[n];
    } 
    private void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        uf[a] += uf[b];
        uf[b] = a;
    }

    public boolean equationsPossible(String[] equations) {
        uf = new int[26];
        for (int i=0; i<26; i++) {
            uf[i] = -1;
        }
            
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                continue;
            }
            int lhs = eq.charAt(0) - 'a';
            int rhs = eq.charAt(3) - 'a';
            merge(lhs, rhs);
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                continue;
            }
            int lhs = eq.charAt(0) - 'a';
            int rhs = eq.charAt(3) - 'a';
            if (find(lhs) == find(rhs)) {
                return false;
            }            
        }

        return true;
    }
}