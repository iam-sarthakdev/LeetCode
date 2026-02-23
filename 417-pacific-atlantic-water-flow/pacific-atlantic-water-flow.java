class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        // visited arrays for both oceans
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        /*
         STEP 1:
         Add all Pacific border cells to pacQueue
         (top row + left column)
        */
        for (int i = 0; i < m; i++) {
            pacQueue.offer(new int[]{i, 0});      // left border
            pacific[i][0] = true;

            atlQueue.offer(new int[]{i, n - 1});  // right border
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacQueue.offer(new int[]{0, j});      // top border
            pacific[0][j] = true;

            atlQueue.offer(new int[]{m - 1, j});  // bottom border
            atlantic[m - 1][j] = true;
        }

        /*
         STEP 2:
         Run BFS for both oceans
        */
        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);

        /*
         STEP 3:
         Cells reachable from BOTH oceans
        */
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    /*
     Multi-source BFS
     Marks all cells reachable from a given ocean
    */
    private void bfs(int[][] heights,
                     Queue<int[]> queue,
                     boolean[][] visited) {

        int m = heights.length;
        int n = heights[0].length;

        // 4-direction movement
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] d : dirs) {

                int newRow = row + d[0];
                int newCol = col + d[1];

                /*
                 Conditions:
                 1. Inside grid
                 2. Not visited yet
                 3. Height is >= current height
                */
                if (newRow >= 0 && newCol >= 0 &&
                    newRow < m && newCol < n &&
                    !visited[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[row][col]) {

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}