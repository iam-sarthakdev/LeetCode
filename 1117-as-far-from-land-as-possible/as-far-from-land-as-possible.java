class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int maxDist = 0;
        int[][] dist = new int[n][n];

        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0; i < n; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
        int[][] dirn = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            // check 4 dirn
            for(int[] d : dirn){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0){
                    grid[nr][nc] = 1;
                    dist[nr][nc] = 1 + dist[r][c];
                    q.add(new int[]{nr, nc});
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }
        return maxDist == 0 ? -1 : maxDist;
    }
}