class Solution {
    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> index = new HashMap<>();
        for (int i=0; i<26; i++) {
            index.put(keyboard.charAt(i), i);
        }
        
        int ans = 0;
        int curr = 0;
        for (int i=0; i<word.length(); i++) {
            ans += Math.abs(curr-index.get(word.charAt(i)));
            curr = index.get(word.charAt(i));
        }
        
        return ans;
    }
}