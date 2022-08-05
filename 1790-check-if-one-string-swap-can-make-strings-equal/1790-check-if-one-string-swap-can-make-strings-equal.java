class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char tmp1 = 0;
        char tmp2 = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 0) {
                    tmp1 = s1.charAt(i);
                    tmp2 = s2.charAt(i);
                    count++;
                } else if (count == 1) {
                    if (tmp1 != s2.charAt(i) || tmp2 != s1.charAt(i)) {
                        return false;
                    }
                    count++;
                } else if (count == 2) {
                    return false;
                }

            }
        }
        if (count == 1) {
            return false;
        }
        return true;
    }
}