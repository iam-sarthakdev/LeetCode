class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        // dist[0][0] = 0;

        int[] dr = {-1,1,0,0};
        int[] dc = {0, 0, -1, 1};

        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            // if(effort > dist[r][c]) continue;

            if(r == n-1 && c == m-1) return effort;
            // traverse in 4 dirn
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc < m && nc >= 0){
                    int edgeWeight = Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort = Math.max(edgeWeight, effort);

                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}