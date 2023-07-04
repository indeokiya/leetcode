class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int s = 0;
        
        while (s < chars.length) {
            int length = 1;
            while (s + length < chars.length && chars[s + length] == chars[s]) {
                length++;
            }
            chars[index++] = chars[s];
            if (length != 1) {
                char[] lengths = String.valueOf(length).toCharArray();
                for (char c : lengths) {
                    chars[index++] = c;
                } 
            }
            s += length;
        }
        
        return index;
    }
}