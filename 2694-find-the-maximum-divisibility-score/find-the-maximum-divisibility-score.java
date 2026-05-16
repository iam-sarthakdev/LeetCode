class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {

        int bestCount = 0;
        int divisor = Integer.MAX_VALUE;

        for (int div : divisors) {

            int count = 0;

            for (int num : nums) {
                if (num % div == 0) {
                    count++;
                }
            }

            if (count > bestCount || (count == bestCount && div < divisor)) {
                bestCount = count;
                divisor = div;
            }
        }

        return divisor;
    }
}