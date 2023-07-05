class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        for (int step=1; !q.isEmpty(); step++) {
            int size = q.size();
            while (size-->0) {
                char[] from = q.poll().toCharArray();
                for (int i=0; i<from.length; i++) {
                    char original = from[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        from[i] = c;
                        String changed = new String(from);
                        if (words.contains(changed)) {
                            if (changed.equals(endWord)) return step + 1;
                            q.add(changed);
                            words.remove(changed);
                        }
                    }
                    from[i] = original;
                }
            }
        }
        
        return 0;
    }
}