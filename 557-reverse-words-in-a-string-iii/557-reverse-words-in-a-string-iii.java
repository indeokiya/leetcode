class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int startIndex = 0;
        s += ' ';
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                //int tmp = startIndex;
                for (int j = i-1; j>=startIndex; j--) {
                    //ans[tmp++] = s.charAt(j);
                    ans.append(s.charAt(j));
                }
                if (i < s.length()-1) {
                    ans.append(' ');
                    startIndex = i+1;
                }

            }
        }
        
        return ans.toString();
    }
}