class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int level = 1;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    int[] pair = q.poll();
                int row = pair[0];
                int col = pair[1];

                for(int j = 0; j < 4; j++){
                    int nr = row + dr[j];
                    int nc = col + dc[j];

                    if(nr < n && nr >= 0 && nc < m && nc >= 0 && mat[nr][nc] == 1 && !vis[nr][nc]){
                        q.add(new int[]{nr, nc});
                        vis[nr][nc] = true;
                        dist[nr][nc] = level;
                    }
                }
                }
                level++;
                }
            return dist;
        }
}
    