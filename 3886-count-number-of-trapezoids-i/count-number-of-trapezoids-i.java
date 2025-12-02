class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {

        // Step 1: Count how many points lie on each y-level
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);
        }

        // Step 2: For each y-level compute C(cnt,2)
        List<Long> bases = new ArrayList<>();
        for (int cnt : freq.values()) {
            if (cnt >= 2) {
                long c = (long) cnt * (cnt - 1) / 2;  // safe
                bases.add(c % MOD);
            }
        }

        // Step 3: Sum bases[i] * bases[j] over all i < j
        long ans = 0;
        long prefix = 0;

        for (long b : bases) {
            ans = (ans + (prefix * b) % MOD) % MOD;
            prefix = (prefix + b) % MOD;
        }

        return (int) ans;
    }
}
