class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i=0; i<26; i++) {
            index[keyboard.charAt(i)-'a'] = i;
        }
        
        int ans = 0;
        int curr = 0;
        for (char c : word.toCharArray()) {
            ans += Math.abs(curr - index[c-'a']);
            curr = index[c-'a'];
        }
        
        return ans;
    }
}