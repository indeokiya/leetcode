class Solution {
private:
    int row[9], col[9], box[9];
    
    void setInput(vector<vector<char>>& board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (!isdigit(board[i][j])) continue;
                int num = 1 << (board[i][j] - '1');
                row[i] |= num;
                col[j] |= num;
                box[3*(i/3) + j/3] |= num;
            }
        }
    }
    
    bool backtracking(int idx, vector<vector<char>>& board) {
        if (idx == 9*9) return true;
        int r = idx / 9, c = idx % 9;
        char& curr = board[r][c];
        if (isdigit(curr)) return backtracking(idx+1, board);
        
        for (int i=0; i<9; i++) {
            int num = 1 << i;
            if ((row[r] & num) || (col[c] & num) || box[3*(r/3) + c/3] & num) continue;
            
            row[r] |= num; col[c] |= num; box[3*(r/3) + c/3] |= num;
            curr = '1' + i;
            if (backtracking(idx+1, board)) return true;
            
            row[r] ^= num; col[c] ^= num; box[3*(r/3) + c/3] ^= num;
            curr = '.';
        }
        
        return false;
    }
    
public:
    void solveSudoku(vector<vector<char>>& board) {
        setInput(board);
        assert(backtracking(0, board));
    }
};