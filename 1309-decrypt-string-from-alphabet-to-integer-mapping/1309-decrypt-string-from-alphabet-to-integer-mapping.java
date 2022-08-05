class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (p < s.length()) {
            if (p < s.length()-2 && s.charAt(p+2) == '#') {
                sb.append((char)(96+Integer.parseInt(s.substring(p, p+2))));
                p += 3;
            } else {
                sb.append((char)(96+(int)s.charAt(p++) - (int)'0'));
            }
        }
        return sb.toString();
    }
}