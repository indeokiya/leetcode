class Solution {
private:
    set<char> row[9];
    set<char> col[9];
    set<char> sqr[9];
    
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;
                
                if (row[i].find(curr) != row[i].end()) {
                    return false;
                } else {
                    row[i].insert(curr);
                }
                
                if (col[j].find(curr) != col[j].end()) {
                    return false;
                } else {
                    col[j].insert(curr);
                }

                int idx = 3*(i/3) + j/3;
                if (sqr[idx].find(curr) != sqr[idx].end()) {
                    return false;
                } else {
                    sqr[idx].insert(curr);
                }
            }
        }
        
        return true;
    }
};