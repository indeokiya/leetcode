class Solution {
    private List<String> ans;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        backTracking(s, new StringBuilder(), wordDict);
        return ans;
    }

    private void backTracking(String s, StringBuilder sb, List<String> wordDict) {
        if (s == "") {
            ans.add(sb.deleteCharAt(sb.length()-1).toString());
            return;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                StringBuilder nsb = new StringBuilder(sb);
                nsb.append(word).append(" ");
                backTracking(s.substring(word.length()), nsb, wordDict);
            }
        }
    }
}