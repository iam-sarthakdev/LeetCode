    class Solution{
            public long maxEnergyBoost(int[] A, int[] B) {
        long a0 = 0, a1 = 0, b0 = 0, b1 = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            a1 = Math.max(a0 + A[i], b0);
            b1 = Math.max(b0 + B[i], a0);
            a0 = a1; b0 = b1;
        }
        return Math.max(a1, b1);
    }
    }
