class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // simple increment
                return digits;    // no carry, done
            }
            digits[i] = 0;        // digit was 9, becomes 0
        }

        // all digits were 9
        int[] res = new int[n + 1];
        res[0] = 1;               // e.g., 999 -> 1000
        return res;
    }
}
