class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {

        // group points by y-level
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        // build sorted x-arrays
        List<int[]> levels = new ArrayList<>();
        for (List<Integer> xs : map.values()) {
            if (xs.size() < 2) continue;
            Collections.sort(xs);
            int n = xs.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = xs.get(i);
            levels.add(arr);
        }

        long ans = 0;
        int m = levels.size();

        // count overlaps between each pair of y-levels
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                ans = (ans + countOverlap(levels.get(i), levels.get(j))) % MOD;
            }
        }
        return (int) ans;
    }

    // count overlapping trapezoid bases between level A and B
    private long countOverlap(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        long count = 0;

        // precompute prefix for right endpoints
        int[] maxA = new int[n];
        int[] maxB = new int[m];
        int[] minA = new int[n];
        int[] minB = new int[m];

        // build max right endpoints from A
        for (int i = 0; i < n; i++) maxA[i] = A[n - 1] - A[i];
        for (int i = 0; i < m; i++) maxB[i] = B[m - 1] - B[i];

        // build min left endpoints
        for (int i = 0; i < n; i++) minA[i] = A[i] - A[0];
        for (int i = 0; i < m; i++) minB[i] = B[i] - B[0];

        // two pointer overlap count
        int p = m - 1;
        for (int i = 0; i < n - 1; i++) {
            // count j such that B[j] < A[i+1] AND A[i] < B[j+1]
            while (p > 0 && B[p] >= A[n - 1] - maxA[i]) p--;
            count += Math.max(0, p);
        }
        return count;
    }
}
