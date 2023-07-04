class Solution {
    private String str = "1";
    
    public String countAndSay(int n) {
        for (int i=2; i<=n; i++) {
            call();
        }
        
        return str;
    }
    
    public void call() {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        
        int s = 0;
        while (s < chars.length) {
            int length = 1;
            while (s + length < chars.length && chars[s + length] == chars[s]) {
                length++;
            }
            sb.append(length).append(chars[s]);
            s += length;
        }
        str = sb.toString();
    }
}