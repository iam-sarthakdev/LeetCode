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

            while(!q.isEmpty()){
                int[] pair = q.poll();
                int row = pair[0];
                int col = pair[1];

                // check up
                if(row - 1 >= 0 && !vis[row - 1][col]){
                    dist[row-1][col] = dist[row][col] + 1;
                    vis[row-1][col] = true;
                    q.add(new int[]{row-1, col});
                }
                // check down
                if(row + 1 < n && !vis[row + 1][col]){
                    dist[row+1][col] = dist[row][col] + 1;
                    vis[row+1][col] = true;
                    q.add(new int[]{row+1, col});
                }
                // check right
                if(col + 1 < m && !vis[row][col+1]){
                    dist[row][col+1] = dist[row][col] + 1;
                    vis[row][col+1] = true;
                    q.add(new int[]{row, col+1});
                }
                // check left
                if(col - 1 >= 0 && !vis[row][col-1]){
                    dist[row][col-1] = dist[row][col] + 1;
                    vis[row][col-1] = true;
                    q.add(new int[]{row, col-1});
                }
            }
            return dist;
        }
    }