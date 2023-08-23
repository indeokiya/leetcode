class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> dict = new HashSet<>(Arrays.asList(words));
        final List<String> ans = new ArrayList<>();

        for (String word : words) {
            dict.remove(word);
            final int len = word.length();
            final boolean[] memo = new boolean[len];
            for (int i=0; i<=len-1; i++) {
                for (int j=i+1; j<=len; j++) {
                    if ((i==0 || memo[i-1]) && dict.contains(word.substring(i, j))) {
                        memo[j-1] = true;
                    }
                }
            }
            dict.add(word);
            if (memo[len-1]) {
                ans.add(word);
            }
        }



        return ans;
    }
}