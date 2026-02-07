class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean[][] vis = new boolean[n][m];

        //DFS from top & bottom rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1)
                dfs(0, j, grid, vis);

            if (grid[n - 1][j] == 1)
                dfs(n - 1, j, grid, vis);
        }

        //DFS from left & right columns (skip corners)
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] == 1)
                dfs(i, 0, grid, vis);

            if (grid[i][m - 1] == 1)
                dfs(i, m - 1, grid, vis);
        }

        //Flip all unvisited 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // DFS to mark all boundary-connected 0 as visited
    private void dfs(int r, int c, int[][] grid, boolean[][] vis) {

        //Invalid cell or already processed
        if (r < 0 || c < 0 ||
            r >= grid.length || c >= grid[0].length ||
            grid[r][c] != 1 || vis[r][c]) {
            return;
        }

        //Mark this cell as safe
        vis[r][c] = true;

        //Explore in all 4 directions
        dfs(r - 1, c, grid, vis); // up
        dfs(r + 1, c, grid, vis); // down
        dfs(r, c - 1, grid, vis); // left
        dfs(r, c + 1, grid, vis); // right
    }
}