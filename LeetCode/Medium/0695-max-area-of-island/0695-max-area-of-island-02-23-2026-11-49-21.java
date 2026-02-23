class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid, vis);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int row, int col, int[][] grid, boolean[][] vis){

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || vis[row][col]){
            return 0;
        }
        int area = 1;
        vis[row][col] = true;
        // explore 4 dirn
        area += dfs(row + 1, col, grid, vis);
        area += dfs(row - 1, col, grid, vis);
        area += dfs(row, col+1, grid, vis);
        area += dfs(row, col-1, grid, vis);

        return area;
    }
}