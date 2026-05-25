class Solution {
    int check = 0;
    public void solveSudoku(char[][] board) {
        check =0; 
        solve(board, 0,0);
    }
    public void solve(char[][] board, int row, int col){
        // Base case
        if(row == 9){
            check = 1;
            return;
        }

       else if(board[row][col] != '.'){
        if(col != 8) solve(board, row, col + 1);
        else solve(board, row + 1, 0);
    }
    else {
    for(char ch = '1'; ch <= '9'; ch++){
        if(isSafe(board, row, col, ch)){
            board[row][col] = ch;
            if(col != 8) solve(board, row, col + 1);
        else solve(board, row + 1, 0);

        if(check ==  1) return;
        board[row][col] = '.';
        }
    }
}
    }
    public boolean isSafe(char[][] board, int row, int col, char num){

        // check row 
        for(int i = 0; i < 9; i++){
           if(board[row][i] == num)return false;
        }
        // check column
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num) return false;
        }
        // check 3x3 grid
       int sRow = row/3*3;
      int sCol = col/3*3;
        for(int i = sRow; i < sRow+3; i++){
            for(int j = sCol; j < sCol+3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
}