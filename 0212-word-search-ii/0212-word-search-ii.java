class Solution {
    List<String> ans;
    int M, N;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = constructTrie(words);
        M = board.length;
        N = board[0].length;
        ans = new LinkedList<>();

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backTracking(i, j, root, board);
                }
            }
        }

        return ans;
    }

    private TrieNode constructTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                    continue;
                }
                TrieNode newNode = new TrieNode();
                node.children.put(c, newNode);
                node = newNode;
            }
            node.word = word;
        }
        return root;
    }

    private void backTracking(int r, int c, TrieNode parent, char[][] board) {
        TrieNode node = parent.children.get(board[r][c]);
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        if (node.children.isEmpty()) {
            parent.children.remove(board[r][c]);
            return;
        }

        char tmp = board[r][c];
        board[r][c] = '-';
        for (int d=0; d<4; d++) {
            int nR = r + dr[d];
            int nC = c + dc[d];
            if (nR < 0  || nR >= M || nC < 0 || nC >= N || !node.children.containsKey(board[nR][nC])) {
                continue;
            }
            backTracking(nR, nC, node, board);
        }
        board[r][c] = tmp;
    }
}

class TrieNode {
    protected HashMap<Character, TrieNode> children;
    protected String word;

    public TrieNode() {
        this.children = new HashMap<>();
        word = null;
    }
}