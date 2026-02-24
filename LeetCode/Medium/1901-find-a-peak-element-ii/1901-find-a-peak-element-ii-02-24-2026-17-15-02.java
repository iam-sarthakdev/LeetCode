class Solution {

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int midCol = left + (right - left) / 2;

            /*
             STEP 1:
             Find row index of maximum element in mid column.
             */
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            /*
             STEP 2:
             Get left and right neighbors (if exist).
             */
            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightVal = (midCol + 1 < n) ? mat[maxRow][midCol + 1] : -1;

            /*
             STEP 3:
             Check if current is peak.
             */
            if (mat[maxRow][midCol] > leftVal &&
                mat[maxRow][midCol] > rightVal) {

                return new int[]{maxRow, midCol};
            }

            /*
             STEP 4:
             Move toward larger neighbor.
             */
            else if (rightVal > mat[maxRow][midCol]) {
                left = midCol + 1;  // move right
            } else {
                right = midCol - 1; // move left
            }
        }

        return new int[]{-1, -1};  // problem guarantees peak exists
    }
}