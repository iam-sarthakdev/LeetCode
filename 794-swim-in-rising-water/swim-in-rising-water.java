class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        int maxTime = 0;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0];
            int r = curr[1];
            int c = curr[2];

            maxTime = Math.max(maxTime, currTime);
            if(r == n-1 && c == n-1) return maxTime;

            // check 4 dirn
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){
                    pq.add(new int[] {grid[nr][nc], nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }
        return maxTime;
    }
}