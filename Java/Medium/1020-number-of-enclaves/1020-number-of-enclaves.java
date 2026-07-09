class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean[][] vis = new boolean[n][m];

        //DFS from top & bottom rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1)
                bfs(0, j, grid, vis);

            if (grid[n - 1][j] == 1)
                bfs(n - 1, j, grid, vis);
        }

        //DFS from left & right columns (skip corners)
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][0] == 1)
                bfs(i, 0, grid, vis);

            if (grid[i][m - 1] == 1)
                bfs(i, m - 1, grid, vis);
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

    // BFS to mark all boundary-connected 0 as visited
    private void bfs(int r, int c, int[][] grid, boolean[][] vis) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        vis[r][c] = true;

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int x = pair[0];
            int y = pair[1];

            // check up
            if(x - 1 >= 0 && grid[x-1][y] == 1 && !vis[x-1][y]){
                q.add(new int[]{x-1, y});
                vis[x-1][y] = true;
            }
            // check down
            if(x + 1 < grid.length && grid[x+1][y] == 1 && !vis[x+1][y]){
                q.add(new int[]{x+1, y});
                vis[x+1][y] = true;
            }
            // check right
            if(y + 1 < grid[0].length && grid[x][y+1] == 1 && !vis[x][y+1]){
                q.add(new int[]{x, y+1});
                vis[x][y+1] = true;
            }
            // check left
            if(y - 1 >= 0 && grid[x][y-1] == 1 && !vis[x][y-1]){
                q.add(new int[]{x, y-1});
                vis[x][y-1] = true;
            }
        }
    }
}