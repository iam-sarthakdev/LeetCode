class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;          // water height = 0
                    q.offer(new int[]{i, j}); // multi-source BFS
                } else {
                    height[i][j] = -1;         // unvisited land
                }
            }
        }

        // 4-direction movement
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // boundary + unvisited check
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return height;
    }
}
