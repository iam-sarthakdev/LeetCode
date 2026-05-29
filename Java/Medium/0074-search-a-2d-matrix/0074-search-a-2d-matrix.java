class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1; // index
        while(right >= left){
            int mid = left + (right - left)/2;

            int row = mid / n; // row representaton
            int col = mid % n; // col representaton

            int value = matrix[row][col];
            if(value == target) return true;
            else if(value < target) left = mid + 1;
            else right = mid - 1;

        }
        return false;
    }
}