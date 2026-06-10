class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{i, j});

        grid[i][j] = '0'; // mark visited
        
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            // check up
            if(r - 1 >= 0 && grid[r-1][c] == '1'){
                grid[r-1][c] = '0';
                q.add(new int[]{r-1, c});
            }
            // check down
            if(r + 1 < grid.length && grid[r+1][c] == '1'){
                grid[r+1][c] = '0';
                q.add(new int[]{r+1, c});
            }
            // check right
            if(c + 1 < grid[0].length && grid[r][c+1] == '1'){
                grid[r][c+1] = '0';
                q.add(new int[]{r, c + 1});
            }
            // check left
            if(c - 1 >= 0 && grid[r][c-1] == '1'){
                grid[r][c-1] = '0';
                q.add(new int[]{r, c-1});
            }
        }
    }
}