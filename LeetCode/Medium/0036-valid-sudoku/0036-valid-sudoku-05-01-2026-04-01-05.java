class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                char num = board[i][j];
                board[i][j] = '.';
        if(isSafe(board, i ,j , num) == false) return false;
         board[i][j] = num;
            }    
        }
        return true;
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