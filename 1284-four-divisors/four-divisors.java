class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int n : nums) {
            int count = 2;         // 1 and n are divisors
            int sum   = 1 + n;
            
            // Check for other divisors up to sqrt(n)
            for (int i = 2; i <= n / i; ++i) {
                if (n % i == 0) {
                    // i is a divisor
                    count++;
                    sum += i;

                    // paired divisor n / i
                    if (i * i != n) {
                        count++;
                        sum += n / i;
                    }

                    // early exit if more than 4 divisors
                    if (count > 4) {
                        break;
                    }
                }
            }

            // only add sum if exactly 4 divisors
            if (count == 4) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}
