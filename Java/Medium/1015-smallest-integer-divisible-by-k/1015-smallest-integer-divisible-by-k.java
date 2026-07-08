public class Solution {
    public int smallestRepunitDivByK(int K) {
        // If K is 1, the smallest number "1" works (length = 1)
        if (K == 1) return 1;
        // If K is divisible by 2 or 5, never possible (numbers of only '1' can't be divisible by 2 or 5)
        if (K % 2 == 0 || K % 5 == 0) return -1;

        boolean[] seen = new boolean[K]; // track remainders we've seen
        int remainder = 1 % K;
        int length = 1;

        // iterate until remainder becomes 0 (success) or we loop (failure)
        while (remainder != 0 && !seen[remainder]) {
            seen[remainder] = true;
            // append another '1': newNumber = oldNumber * 10 + 1
            remainder = (remainder * 10 + 1) % K;
            length++;
        }

        return remainder == 0 ? length : -1;
    }
}