class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int tmp;
        while (p < s.length()) {
            if (p < s.length()-2 && s.charAt(p+2) == '#') {
                tmp = Integer.parseInt(s.substring(p, p+2));
                sb.append((char)(96+tmp));
                p += 3;
            } else {
                tmp = (int)s.charAt(p++) - (int)'0';
                sb.append((char)(96+tmp));
            }
            System.out.println(p);
    
        }
        return sb.toString();
    }
}