class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for (int i=0; i<26; i++) {
            myMap.put(order.charAt(i), i);
        }
        int tmp_len;
        int a;
        int b;
        
        for (int i=0; i<words.length-1; i++) {
            tmp_len = Math.min(words[i].length(), words[i+1].length());
            for (int j=0; j<tmp_len; j++) {
                a = myMap.get(words[i].charAt(j));
                b = myMap.get(words[i+1].charAt(j));
                if (a < b) {
                    break;
                } else if (a > b) {
                    return false;
                }
                if (j == tmp_len-1 && words[i].length() > words[i+1].length() ) return false;
            }
            
        }
        
        return true;
        
    }
}