class Solution {
    private enum Result {
        TRUE, FALSE
    }
    private Result[][] visited;

    public boolean isMatch(String s, String p) {
        visited = new Result[s.length()+1][p.length()+1];
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int p1, int p2) {
        if (visited[p1][p2] != null) {
            return visited[p1][p2] == Result.TRUE;
        }
        boolean ans;
        if (p2 == p.length()) {
            ans = p1 == s.length();
        } else {
            boolean first_match = p1 < s.length() &&
                (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '.');
            if (p2 < p.length() -1 && p.charAt(p2+1) == '*') {
                ans = match(s, p, p1, p2+2) || (first_match && match(s, p, p1+1, p2));
            } else {
                ans = first_match && match(s, p, p1+1, p2+1);
            }
        }
        visited[p1][p2] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}