class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int maxNum = 0;
        
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        
        int prev, curr;
        
        if (maxNum < m.size() + m.size() * Math.log(m.size()) / Math.log(m.size())) {
            prev = 0;
            curr = m.getOrDefault(1, 0);
            for (int i=2; i<= maxNum; i++) {
                int tmp = Math.max(prev + m.getOrDefault(i, 0), curr);
                prev = curr;
                curr = tmp;
            }
        } else {
            List<Integer> keys = new ArrayList<>(m.keySet());
            Collections.sort(keys);

            prev = 0;
            curr = m.get(keys.get(0));
            for (int i=1; i<keys.size(); i++) {
                // System.out.println("key is : " + key + ", # is : " + m.get(key));
                if (keys.get(i-1) + 1 == keys.get(i)) {
                    int tmp = Math.max(prev + m.get(keys.get(i)), curr);
                    prev = curr;
                    curr = tmp;
                } else {
                    prev = curr;
                    curr += m.get(keys.get(i));
                }
            }
        }
        return curr;
    }
}