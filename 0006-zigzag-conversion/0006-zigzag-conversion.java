class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int offset = 2*(numRows-1);

        for (int row=0; row<numRows; row++) {
            int idx = row;

            while (idx < length) {
                sb.append(s.charAt(idx));
                if (row != 0 && row != numRows-1) {
                    int secondIdx = idx + offset - 2*row;
                    if (secondIdx < length) {
                        sb.append(s.charAt(secondIdx));
                    }
                }
                idx += offset;
            }
        }

        return sb.toString();        
    }
}

/*

i번째 행 (0 to N-1)
i, i + 2*(N-1), i + 4*(N-1), .....
i, i+2*(N-1-i) , i + 2*(N-1), i + 2*(N-1) + 2*(N-1-i) ,i + 4*(N-1), ....


N-1, N-1 + 2(N-1), ...


*/