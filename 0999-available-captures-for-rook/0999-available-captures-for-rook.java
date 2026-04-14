class Solution {
    public int numRookCaptures(char[][] board) {
        
        int r = -1, c = -1;
        
        // Step 1: Find R
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                }
            }
        }
        
        int count = 0;
        
        // Up
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'B') break;
            if (board[i][c] == 'p') {
                count++;
                break;
            }
        }
        
        // Down
        for (int i = r + 1; i < 8; i++) {
            if (board[i][c] == 'B') break;
            if (board[i][c] == 'p') {
                count++;
                break;
            }
        }
        
        // Left
        for (int j = c - 1; j >= 0; j--) {
            if (board[r][j] == 'B') break;
            if (board[r][j] == 'p') {
                count++;
                break;
            }
        }
        
        //Right
        for (int j = c + 1; j < 8; j++) {
            if (board[r][j] == 'B') break;
            if (board[r][j] == 'p') {
                count++;
                break;
            }
        }
        
        return count;
    }
}