class Solution {
    public int fib(int n) {
        int res = 0;
        // base case
        if(n <= 1) return n; 
        return res = res + fib(n-1) + fib(n-2);
    }
}