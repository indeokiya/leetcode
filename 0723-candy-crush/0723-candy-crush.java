class Solution {
    private int M, N;

    public int[][] candyCrush(int[][] board) {
        M = board.length;
        N = board[0].length;

        while (true) {
            boolean needToCrush = mark(board);
            if (!needToCrush) break;
            crush(board);
            drop(board);
        }
        
        return board;
    }

    private void drop(int[][] board) {

        for (int j=0; j<N; j++) {
            int p1 = M-1, p2 = M-1;
            while (p2 >= 0) {
                if (board[p2][j] == 0) {
                    p2--;
                    continue;
                }

                board[p1--][j] = board[p2--][j];
            }

            while (p1 >= 0) {
                board[p1--][j] = 0;
            }
        }
    }

    private boolean mark(int[][] board) {
        boolean needToCrush = false;
        for (int i=0; i<M; i++) {
            for (int j=1; j<N-1; j++) {
                int curr = Math.abs(board[i][j]);
                if (curr != 0 && Math.abs(board[i][j-1]) == curr && curr == board[i][j+1]) {
                    needToCrush = true;
                    board[i][j-1] = board[i][j] = board[i][j+1] = -curr;
                }
            }
        }

        for (int j=0; j<N; j++) {
            for (int i=1; i<M-1; i++) {
                int curr = Math.abs(board[i][j]);
                if (curr != 0 && Math.abs(board[i-1][j]) == curr && curr == Math.abs(board[i+1][j])) {
                    needToCrush = true;
                    board[i-1][j] = board[i][j] = board[i+1][j] = -curr;
                }
            }
        }
        return needToCrush;
    }

    private void crush(int[][] board) {
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] < 0) board[i][j] = 0;
            }
        }
    }
}