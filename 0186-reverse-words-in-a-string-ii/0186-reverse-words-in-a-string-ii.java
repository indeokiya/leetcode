class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int start=0, end=0;
        
        while (start < s.length) {
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            
            reverse(s, start, end-1);
            
            start = ++end;
        }
    }
    
    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}