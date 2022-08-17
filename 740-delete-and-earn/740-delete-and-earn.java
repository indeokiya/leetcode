class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + num);    
        }
        
        List<Integer> keys = new ArrayList<>(m.keySet());
        Collections.sort(keys);

        int prev = 0;
        int curr = m.get(keys.get(0));
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
        
        return curr;
    }
}