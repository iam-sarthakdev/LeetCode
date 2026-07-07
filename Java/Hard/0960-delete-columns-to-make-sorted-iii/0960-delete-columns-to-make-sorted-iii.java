class Solution {
    public int minDeletionSize(String[] A) {
        int rows = A.length;
        int cols = A[0].length();

        int[] dp = new int[cols];
        Arrays.fill(dp, 1);

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < j; i++) {

                boolean canExtend = true;

                // check all rows
                for (int r = 0; r < rows; r++) {
                    if (A[r].charAt(i) > A[r].charAt(j)) {
                        canExtend = false;
                        break;
                    }
                }

                if (canExtend) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int maxKeep = 0;
        for (int val : dp) maxKeep = Math.max(maxKeep, val);

        return cols - maxKeep;
    }
}
