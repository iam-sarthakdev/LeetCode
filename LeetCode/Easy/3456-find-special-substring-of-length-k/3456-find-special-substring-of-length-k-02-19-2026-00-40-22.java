class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        if (s.length() < k) return false;

        for (int i = 0; i <= s.length() - k; i++) {
            int count = 1;

            for (int j = i; j < i + k - 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == k && (i == 0 || s.charAt(i - 1) != s.charAt(i)) && 
                (i + k == s.length() || s.charAt(i + k) != s.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
