class StringIterator {
    private char[] chars;
    private int[] counts;
    private int curr;

    public StringIterator(String compressedString) {
        curr = 0;
        chars = new char[1000];
        counts = new int[1000];
        for (int idx=0, iter=0, size=compressedString.length(); iter<size; idx++) {
            char c = compressedString.charAt(iter++);
            int cnt = 0;
            while (iter < size) {
                char tmp = compressedString.charAt(iter);
                if (tmp < '0' || tmp > '9') {
                    break;
                }
                cnt *= 10;
                cnt += tmp - '0';
                iter++;
            }
            chars[idx] = c;
            counts[idx] = cnt;
        }
    }
    
    public char next() {
        if (counts[curr] == 0) {
            ++curr;
        }
        if (counts[curr] == 0) {
            return ' ';
        }
        counts[curr]--;
        return chars[curr];
    }
    
    public boolean hasNext() {
        if (counts[curr] == 0) {
            ++curr;
        }
        return counts[curr] > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */