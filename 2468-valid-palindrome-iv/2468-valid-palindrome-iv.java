class Solution {
    public boolean makePalindrome(String s) {
        return countMissPair(s) <= 2 ? true : false;
    }

    private int countMissPair(String s) {
        int cnt = 0;
        for (int i=0, len=s.length(); i<len/2; i++) {
            if (s.charAt(i) != s.charAt(len-1-i)) {
                cnt++;
            }
        }

        return cnt;
    }
}