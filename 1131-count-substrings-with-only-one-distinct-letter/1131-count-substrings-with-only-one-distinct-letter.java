class Solution {
    public int countLetters(String s) {
        int length = s.length();
        int i = 0;
        int sum = 0;

        while (i < length) {
            char c = s.charAt(i++);
            int cnt = 1;
            while (i < length && s.charAt(i) == c) {
                cnt++;
                i++;
            }
            sum += (cnt+1) * cnt / 2;
        }

        return sum;
    }
}