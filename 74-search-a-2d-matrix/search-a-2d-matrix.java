class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        while(row < m){
            if(matrix[row][n - 1] == target){
                    return true;
                }
            else{ // our target is in current row
                int left = 0;
                int right = n-1;

                while(right >= left){
                    int mid = left + (right - left)/2;
                    if(matrix[row][mid] == target){
                         return true;
                }else if(matrix[row][mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        row++;
    }
        return false;
}
}