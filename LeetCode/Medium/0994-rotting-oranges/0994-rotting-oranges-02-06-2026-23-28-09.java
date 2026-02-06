class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0 ;
        int row = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                else if(grid[i][j] == 1) freshCount ++;
            }
        }
        if(freshCount == 0) return 0; // no fresh oranges

        int minute = -1;
        while(!q.isEmpty()){
            int size = q.size();
            minute++;
            for(int i= 0; i < size; i++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                // check up
                if(x - 1 >= 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    q.add(new int[]{x-1,y});
                    freshCount--;
                }
                // check down
                if(x + 1 < row && grid[x+1][y] == 1){
                     grid[x+1][y] = 2;
                    q.add(new int[]{x+1,y});
                    freshCount--;
                }
                // check right
                if(y + 1 < cols && grid[x][y+1] == 1){
                     grid[x][y+1] = 2;
                    q.add(new int[]{x,y+1});
                    freshCount--;
                }
                // check left
                if(y - 1 >= 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    q.add(new int[]{x,y-1});
                    freshCount--;
                }
            }
        }
        System.out.println("Fresh left "+ freshCount);
        return freshCount == 0 ? minute : -1;
    }
}