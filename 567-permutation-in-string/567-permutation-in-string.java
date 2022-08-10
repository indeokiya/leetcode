class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1>len2) return false;
        
        HashMap<Character, Integer> myMap = new HashMap<>();
        HashMap<Character, Integer> testMap = new HashMap<>();    
        for (int i=0; i<len1; i++) {
            myMap.put(s1.charAt(i), myMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        int prev = 0;
        int curr = 0;
        while (prev<len2-len1+1) {
            if (!myMap.containsKey(s2.charAt(curr))) { //추가하기전에, 이 원소가 필요 없으면
                testMap.clear();
                prev = ++curr;
                continue;
            }
            testMap.put(s2.charAt(curr), testMap.getOrDefault(s2.charAt(curr), 0) + 1);
            
            curr++;
            if (curr - prev >= len1) {
                if (myMap.equals(testMap)) {
                    return true;
                } 

                if (testMap.get(s2.charAt(prev)) == 1) {
                    testMap.remove(s2.charAt(prev));
                } else {
                    testMap.put(s2.charAt(prev), testMap.get(s2.charAt(prev)) - 1);
                }
                prev++;
            }
        }
        
        
        return false;
    }
}