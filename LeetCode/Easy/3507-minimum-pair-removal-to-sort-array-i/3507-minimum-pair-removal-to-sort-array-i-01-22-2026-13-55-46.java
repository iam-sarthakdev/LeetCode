class Solution {
    public int minimumPairRemoval(int[] nums) {
        java.util.ArrayList<Long> arr = new java.util.ArrayList<>();
        for (int x : nums) arr.add((long) x);

        int ops = 0;

        while (!isNonDecreasing(arr)) {
            int idx = 0;
            long minSum = Long.MAX_VALUE;

            // find leftmost adjacent pair with minimum sum
            for (int i = 0; i < arr.size() - 1; i++) {
                long sum = arr.get(i) + arr.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            // merge that pair
            long merged = arr.get(idx) + arr.get(idx + 1);
            arr.remove(idx + 1);
            arr.set(idx, merged);

            ops++;
        }

        return ops;
    }

    private boolean isNonDecreasing(java.util.ArrayList<Long> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) return false;
        }
        return true;
    }
}
