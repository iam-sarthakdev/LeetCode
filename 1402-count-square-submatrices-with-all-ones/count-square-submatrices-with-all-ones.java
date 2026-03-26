class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int count = 0;

        for(int i = 0; i < n; i++){
            int[] curr = new int[m];
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        curr[j] = 1;
                        count += curr[j];
                    }else{
                      curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j-1]));
                      count += curr[j];
                    }
                }
            }
            prev = curr;
        }
        return count;
    }
}