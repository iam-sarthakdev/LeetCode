class Solution {
    public int maxSumDivThree(int[] nums) {
        int totalSum = 0;

        // Track smallest numbers by remainder group
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int min11 = Integer.MAX_VALUE, min22 = Integer.MAX_VALUE;

        for (int num : nums) {
            totalSum += num;
            int rem = num % 3;

            if (rem == 1) {
                if (num < min1) {
                    min11 = min1;
                    min1 = num;
                } else if (num < min11) {
                    min11 = num;
                }
            } else if (rem == 2) {
                if (num < min2) {
                    min22 = min2;
                    min2 = num;
                } else if (num < min22) {
                    min22 = num;
                }
            }
        }

        // If divisible already, done
        if (totalSum % 3 == 0) return totalSum;

        int result = 0;
        int remainder = totalSum % 3;

        if (remainder == 1) {
            int option1 = (min1 == Integer.MAX_VALUE) ? 0 : totalSum - min1;
            int option2 = (min2 == Integer.MAX_VALUE || min22 == Integer.MAX_VALUE) ? 0 : totalSum - (min2 + min22);
            result = Math.max(option1, option2);
        } else { // remainder == 2
            int option1 = (min2 == Integer.MAX_VALUE) ? 0 : totalSum - min2;
            int option2 = (min1 == Integer.MAX_VALUE || min11 == Integer.MAX_VALUE) ? 0 : totalSum - (min1 + min11);
            result = Math.max(option1, option2);
        }

        return result;
    }
}