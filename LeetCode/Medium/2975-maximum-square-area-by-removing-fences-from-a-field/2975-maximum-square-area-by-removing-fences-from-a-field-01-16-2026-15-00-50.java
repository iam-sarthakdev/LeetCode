import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // Add boundaries to fence lists
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        h.add(m);
        for (int x : hFences) h.add(x);

        v.add(1);
        v.add(n);
        for (int x : vFences) v.add(x);

        // Sort fence positions
        Collections.sort(h);
        Collections.sort(v);

        // Store all possible horizontal distances
        Set<Integer> horizontalDistances = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                horizontalDistances.add(h.get(j) - h.get(i));
            }
        }

        long maxSide = 0;

        // Check vertical distances against horizontal ones
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                int dist = v.get(j) - v.get(i);
                if (horizontalDistances.contains(dist)) {
                    maxSide = Math.max(maxSide, dist);
                }
            }
        }

        if (maxSide == 0) return -1;

        // Return area = side * side (mod)
        return (int) ((maxSide * maxSide) % MOD);
    }
}
