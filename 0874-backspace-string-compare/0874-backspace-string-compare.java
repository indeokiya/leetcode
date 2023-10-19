class Solution {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        int back1 = 0;
        int back2 = 0;

        while (p1>=0 || p2>=0) {
            while (p1 >= 0) {
                if (s.charAt(p1) == '#') {back1++; p1--;}
                else if (back1 > 0) {back1--; p1--;}
                else break;
            }

            while (p2 >= 0) {
                if (t.charAt(p2) == '#') {back2++; p2--;}
                else if (back2 > 0) {back2--; p2--;}
                else break;
            }            

            if (p1>=0 && p2>=0 && s.charAt(p1) != t.charAt(p2)) return false;
            if (p1>=0 != p2>=0) return false;
            p1--; p2--;
        }

        return true;
    }
}