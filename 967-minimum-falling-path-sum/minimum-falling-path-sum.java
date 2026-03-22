class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[n];

        for(int j = 0; j < n; j++){
            prev[j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[n];

            for(int j = 0; j < n; j++){
                int up = prev[j];

                int leftDiag = Integer.MAX_VALUE;
                if(j > 0) leftDiag = prev[j-1];

                int rightDiag = Integer.MAX_VALUE;
                if(j < n -1) rightDiag = prev[j+1];

                curr[j] = matrix[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
            prev = curr;
        }
        int minVal = Integer.MAX_VALUE;
        for(int val : prev){
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }
}