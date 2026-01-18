class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {   
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        backtrack(board, 0, n);
        return result;
    }
    private void backtrack(char[][] board, int row, int n){
             // base case 
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            result.add(temp);
            return;
        }
        for(int col = 0; col < n; col++){
            // check if valid then place a queen
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                            // call recursion 
            backtrack(board, row + 1, n);

            // backtracking 
            board[row][col] = '.';
            }

        }
        }

        private boolean isSafe(char[][] board, int row, int col, int n){

            // check for columns 
            int i = row - 1;
            while(i >= 0 ){
                if(board[i][col] == 'Q') return false;
                i--;
            }

            // check left upper
            int x = row -1;
            int j = col -1;
            while(x >= 0 && j >= 0){
                if(board[x][j] == 'Q') return false;
                x--;
                j--;
            }

            // check right upper
            int y = row - 1;
            int k = col + 1;
            while(y >= 0 && k < n){
                if(board[y][k] == 'Q') return false;
                y--;
                k++;
            }
            return true;
        }  
    }