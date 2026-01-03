class Solution {
    public int numOfWays(int n) {
        final long MOD = 1_000_000_007;

        long f0 = 6, f1 = 6;  // Initial counts for row 1

        for (int i = 2; i <= n; ++i) {
            long newF0 = (3 * f0 + 2 * f1) % MOD;
            long newF1 = (2 * f0 + 2 * f1) % MOD;
            f0 = newF0;
            f1 = newF1;
        }

        return (int) ((f0 + f1) % MOD);
    }
}