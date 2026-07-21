class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;   // max possible time if power split equally
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canRun(mid, n, batteries)) {
                ans = mid;        // mid is possible
                left = mid + 1;   // try for more time
            } else {
                right = mid - 1;  // mid is too large
            }
        }

        return ans;
    }

    // Check if we can run all n computers for 'time'
    private boolean canRun(long time, int n, int[] batteries) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, time);  // each battery contributes at most 'time'
        }

        return total >= (long) n * time;
    }
}