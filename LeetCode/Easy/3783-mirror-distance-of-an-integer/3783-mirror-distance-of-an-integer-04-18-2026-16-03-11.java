class Solution {
    public int mirrorDistance(int n) {
        int reverse = reverse(n);
        return Math.abs(n - reverse);
    }
    public int reverse(int n){
        int reverse  = 0;

        while (n != 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        return reverse;
    }
}