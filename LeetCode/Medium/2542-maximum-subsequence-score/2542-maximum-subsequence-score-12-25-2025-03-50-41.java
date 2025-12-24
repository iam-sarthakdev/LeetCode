class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums2[i];
            a[i][1] = nums1[i];
        }

        Arrays.sort(a, (x, y) -> Integer.compare(y[0], x[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(a[i][1]);
            sum += a[i][1];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.max(ans, sum * a[i][0]);
            }
        }

        return ans;
    }
}
