class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            low = Math.min(matrix[i][0], low);
            high = Math.max(matrix[i][n-1], high);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            int count = 0;
            for(int i = 0; i < n; i++){
                count += countSmallOrEqual(matrix[i], mid);
            }
            if(count < k) low = mid + 1;
            else high = mid-1;
        }
        return low;
    }
    private int countSmallOrEqual(int[] rows, int target){
        int n = rows.length;
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(rows[mid] <= target){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return low;
    }
}