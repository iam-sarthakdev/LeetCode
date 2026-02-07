class Solution {

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        //DFS from top & bottom rows
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board, vis);

            if (board[n - 1][j] == 'O')
                dfs(n - 1, j, board, vis);
        }

        //DFS from left & right columns (skip corners)
        for (int i = 1; i < n - 1; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board, vis);

            if (board[i][m - 1] == 'O')
                dfs(i, m - 1, board, vis);
        }

        //Flip all unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // DFS to mark all boundary-connected 'O' as visited
    private void dfs(int r, int c, char[][] board, boolean[][] vis) {

        //Invalid cell or already processed
        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            board[r][c] != 'O' || vis[r][c]) {
            return;
        }

        //Mark this cell as safe
        vis[r][c] = true;

        //Explore in all 4 directions
        dfs(r - 1, c, board, vis); // up
        dfs(r + 1, c, board, vis); // down
        dfs(r, c - 1, board, vis); // left
        dfs(r, c + 1, board, vis); // right
    }
}
