class Solution {
    public int maxOperations(String s) {
        long ans = 0;
        long ones = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') ones++;
            else if (i == n - 1 || s.charAt(i + 1) == '1') ans += ones;
        }
        // dangerous: possible lossy conversion
        return (int) ans; // cast — will truncate if ans > Integer.MAX_VALUE
    }
}
