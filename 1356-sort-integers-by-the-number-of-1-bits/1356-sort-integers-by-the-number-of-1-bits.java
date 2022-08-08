class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, ArrayList<Integer>> myMap = new HashMap<>();
        
        int mask;
        int len = arr.length;
        int[] ans = new int[len];
        
        int tmp_1count;
        for (int i=0; i<len; i++) {
            mask = 1 << 15;
            tmp_1count = 0;

            while (mask > 0) {
                if ((mask & arr[i]) != 0) {
                    tmp_1count++;
                }
                mask = mask >> 1;
            }
            if (myMap.containsKey(tmp_1count)) {
                myMap.get(tmp_1count).add(arr[i]);
            } else {
                myMap.put(tmp_1count, new ArrayList<Integer>(Arrays.asList(arr[i])));
            }

        }
        
        int size = 0;
        for (int i=0; i<15; i++) {
            if (myMap.containsKey(i)) {
                ArrayList<Integer> tmp = myMap.get(i);
                Collections.sort(tmp);
                for (int j=0; j<tmp.size(); j++) {
                    ans[size++] = tmp.get(j);
                }
            }
        }
         
        return ans;
    }
}