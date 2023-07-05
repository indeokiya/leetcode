class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Integer> m = new HashMap<>();
        m.put(startGene, 0);
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                String gene = q.poll();
                for (String candidate : bank) {
                    if (able(gene, candidate) && !m.containsKey(candidate)) {
                        q.add(candidate);
                        m.put(candidate, m.get(gene)+1);
                    }
                }             
            }
        }
        
        return m.getOrDefault(endGene, -1);
    }
    
    public boolean able(String a, String b) {
        int diff = 0;
        for (int i=0; i<8; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff==1;
    }
}