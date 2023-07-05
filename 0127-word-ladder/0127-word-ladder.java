class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        set.add(beginWord);
        q.add(beginWord);
        for (int step=1; !q.isEmpty(); step++) {
            int size = q.size();
            while (size-->0) {
                String from = q.poll();
                for (String to : wordList) {
                    if (able(from, to) && !set.contains(to)) {
                        if (to.equals(endWord)) {
                            return step + 1;
                        }
                        set.add(to);
                        q.add(to);
                    }
                }
            }
        }
        
        return 0;
    }
    
    public boolean able(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff==1;
    }
}