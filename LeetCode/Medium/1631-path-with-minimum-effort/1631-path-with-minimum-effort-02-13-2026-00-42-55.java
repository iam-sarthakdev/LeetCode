import java.util.*;

class Solution {
    
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        // dist[r][c] = minimum effort required to reach (r,c)
        int[][] dist = new int[n][m];
        
        // Initialize with large value
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // Min Heap -> {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])   // safest comparator
        );
        
        // Start from (0,0) with effort 0
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        // Directions (4 moves)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            // If reached destination -> return answer
            if(r == n - 1 && c == m - 1) {
                return effort;
            }
            
            // Explore 4 directions
            for(int i = 0; i < 4; i++) {
                
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // Check boundary
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    
                    // Edge weight = absolute height difference
                    int edgeWeight = Math.abs(
                        heights[r][c] - heights[nr][nc]
                    );
                    
                    // IMPORTANT LINE:
                    // We take max because effort = max edge in path
                    int newEffort = Math.max(effort, edgeWeight);
                    
                    // If better effort found
                    if(newEffort < dist[nr][nc]) {
                        
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        
        return 0; // will never reach here
    }
}
