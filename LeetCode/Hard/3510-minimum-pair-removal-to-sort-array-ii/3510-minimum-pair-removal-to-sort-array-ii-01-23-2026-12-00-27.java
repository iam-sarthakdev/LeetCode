import java.util.*;

class Solution {

    static class Pair {
        long sum;
        int idx;
        Pair(long s, int i) {
            sum = s;
            idx = i;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] val = new long[n];
        int[] left = new int[n];
        int[] right = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            val[i] = nums[i];
            left[i] = i - 1;
            right[i] = i + 1;
            alive[i] = true;
        }

        int bad = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (val[i] > val[i + 1]) bad++;
        }
        if (bad == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.sum, b.sum)
        );

        for (int i = 0; i + 1 < n; i++) {
            pq.offer(new Pair(val[i] + val[i + 1], i));
        }

        int ops = 0;

        while (bad > 0) {
            Pair cur = pq.poll();
            int i = cur.idx;
            int j = right[i];

            if (j == n || !alive[i] || !alive[j]) continue;
            if (val[i] + val[j] != cur.sum) continue;

            int L = left[i];
            int R = right[j];

            if (L != -1 && val[L] > val[i]) bad--;
            if (val[i] > val[j]) bad--;
            if (R != n && val[j] > val[R]) bad--;

            val[i] += val[j];
            alive[j] = false;
            right[i] = R;
            if (R != n) left[R] = i;

            if (L != -1 && val[L] > val[i]) bad++;
            if (R != n && val[i] > val[R]) bad++;

            if (L != -1) pq.offer(new Pair(val[L] + val[i], L));
            if (R != n) pq.offer(new Pair(val[i] + val[R], i));

            ops++;
        }

        return ops;
    }
}
