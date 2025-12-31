class Solution {
    int count = 0;
    public int totalNQueens(int n) {
       
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        nqueen(board, 0, n);
        return count;
    }
    private void nqueen(char[][] board, int row, int n){

        // Base case
        if(row == n){
            count++;
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';

                nqueen(board, row+1, n);

                board[row][col] = '.';
            }
        }
    }
    private boolean isSafe(char[][] board, int row ,int col, int n){
        int i,j;
        // chech column
        for( i = 0; i < n; i++){
           if(board[i][col] == 'Q') return false;
        }
        // check /
         i = row;
         j = col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        // check \
        i = row;
        j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--; 
    }
    return true;
    }
}