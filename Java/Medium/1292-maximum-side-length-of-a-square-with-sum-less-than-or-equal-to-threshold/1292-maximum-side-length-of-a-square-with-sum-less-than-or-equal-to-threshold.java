class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        int n = mat.length;
        int m = mat[0].length;

        // Prefix sum matrix (extra row & col for easy calculation)
        int[][] prefix = new int[n + 1][m + 1];

        // Build prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] =
                        mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int low = 1, high = Math.min(n, m);
        int ans = 0;

        // Binary search on side length
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(mid, prefix, threshold)) {
                ans = mid;        // mid is possible
                low = mid + 1;    // try bigger square
            } else {
                high = mid - 1;   // reduce size
            }
        }

        return ans;
    }

    // Check if any square of size k has sum <= threshold
    private boolean isValid(int k, int[][] prefix, int threshold) {

        int n = prefix.length;
        int m = prefix[0].length;

        for (int i = 0; i + k < n; i++) {
            for (int j = 0; j + k < m; j++) {

                int sum =
                        prefix[i + k][j + k]
                        - prefix[i][j + k]
                        - prefix[i + k][j]
                        + prefix[i][j];

                if (sum <= threshold) {
                    return true;
                }
            }
        }

        return false;
    }
}