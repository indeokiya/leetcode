class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
//         int len = s.length();
//         int xor1 = 0;
//         int xor2 = 0;
        
//         for (int i=0; i<len; i++) {
//             xor1 ^= s.charAt(i);
//             xor2 ^= t.charAt(i);
//         }
        
//         if (xor1 != xor2) return false;
        
        int[] arr = new int[26];
        int len = s.length();
        for (int i=0; i<len; i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) {
            if (arr[i] != 0) return false; 
        }
        return true;
    }
}