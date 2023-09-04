class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (t.equals(s)) return false;
        if (n1 > n2) return isOneEditDistance(t, s);
        if (n1 + 1 < n2) return false;

        int p1 = 0;
        while (p1 < Math.min(n1, n2)) {
            if (s.charAt(p1) != t.charAt(p1)) break;
            p1++;
        }

        if (n1 == n2) return s.substring(p1+1).equals(t.substring(p1+1));
        return s.substring(p1).equals(t.substring(p1+1));
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