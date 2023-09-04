class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;

        int maxLen = Math.max(s.length(), t.length());
        int minLen = Math.min(s.length(), t.length());

        int p1 = 0;
        for (; p1 < minLen && s.charAt(p1) == t.charAt(p1); p1++) {}
        int p2 = 0;
        for (; p2 < minLen && s.charAt(s.length()-1-p2) == t.charAt(t.length()-1-p2); p2++) {}
        
        return p1 >= maxLen-1-p2;
    }
}


/*

abcdef
abczdef

abcba
abba

abcde
abfde



*/