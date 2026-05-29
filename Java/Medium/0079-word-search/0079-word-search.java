class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int row, int col, String word, int index){

        if(index == word.length()) return true;
        // base case
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)){
            return false;
        }
        char original = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, row + 1, col, word, index+1) || dfs(board, row - 1, col, word, index+1) || dfs(board, row, col+1, word, index+1) || dfs(board, row, col-1, word, index+1);

        board[row][col] = original;

        return found;
    }
}