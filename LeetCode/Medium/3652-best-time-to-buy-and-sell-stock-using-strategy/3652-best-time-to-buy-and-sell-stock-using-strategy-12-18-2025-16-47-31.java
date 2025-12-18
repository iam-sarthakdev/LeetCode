class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        int half = k / 2;
        long delta = 0;

        for (int i = 0; i < half; i++) {
            delta -= (long) strategy[i] * prices[i];
        }
        for (int i = half; i < k; i++) {
            delta += prices[i] - (long) strategy[i] * prices[i];
        }

        long best = delta;

        for (int l = 1; l + k <= n; l++) {
            int out1 = l - 1;
            int in1 = l + half - 1;
            delta += (long) strategy[out1] * prices[out1];
            delta -= (long) strategy[in1] * prices[in1];

            int out2 = l + half - 1;
            int in2 = l + k - 1;
            delta -= prices[out2] - (long) strategy[out2] * prices[out2];
            delta += prices[in2] - (long) strategy[in2] * prices[in2];

            best = Math.max(best, delta);
        }

        return base + Math.max(0, best);
    }
}
