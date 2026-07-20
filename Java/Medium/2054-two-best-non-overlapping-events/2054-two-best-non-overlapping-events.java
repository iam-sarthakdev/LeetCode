class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;

        // suffixMax[i] = max value from i to end
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currValue = events[i][2];
            ans = Math.max(ans, currValue); // take only one event

            int nextIndex = findNextEvent(events, events[i][1]);
            if (nextIndex != -1) {
                ans = Math.max(ans, currValue + suffixMax[nextIndex]);
            }
        }

        return ans;
    }

    // Binary search: first event with start > endTime
    private int findNextEvent(int[][] events, int endTime) {
        int l = 0, r = events.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] > endTime) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
