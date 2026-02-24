class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && !vis[i][j]){
                    if(dfs(grid1, grid2, vis, i ,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid1, int[][] grid2, boolean[][] vis, int r, int c){
        // base case
        if(r < 0 || c < 0 || r >= grid2.length || c >= grid2[0].length || grid2[r][c] == 0 || vis[r][c]){
            return true; 
        }

        vis[r][c] = true;

        boolean isValid = grid1[r][c] == 1;
        // check all 4 neighbours
        boolean down = dfs(grid1, grid2, vis, r + 1, c);
        boolean up = dfs(grid1, grid2, vis, r - 1, c);
        boolean right = dfs(grid1, grid2, vis, r, c+1);
        boolean left = dfs(grid1, grid2, vis, r, c-1);

        return isValid && up && down && left && right;
    }
}