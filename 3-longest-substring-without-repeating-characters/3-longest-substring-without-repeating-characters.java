class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 0; 
        
        HashSet<Character> mySet = new HashSet<>();
        while (right < s.length()) {
            if (mySet.contains(s.charAt(right))) {
                ans = Math.max(ans, mySet.size());
                while(true) {
                    // mySet.remove(s.charAt(left));
                    if (s.charAt(left) != s.charAt(right)) {
                        mySet.remove(s.charAt(left++));
                    } else {
                        left++;
                        right++;
                        break;
                    }
                }
            } else {
                mySet.add(s.charAt(right++));
            }
        }
        ans = Math.max(ans, mySet.size());
        
        
        return ans;
    }
}