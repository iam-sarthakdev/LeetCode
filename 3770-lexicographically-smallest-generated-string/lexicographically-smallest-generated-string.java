class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int L = n + m - 1;

        Character[] word = new Character[L];
        boolean[] forced = new boolean[L];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (word[pos] != null && word[pos] != str2.charAt(j)) {
                        return "";
                    }
                    word[pos] = str2.charAt(j);
                    forced[pos] = true;
                }
            }
        }

        boolean[] free = new boolean[L];
        for (int i = 0; i < L; i++) {
            if (word[i] == null) {
                word[i] = 'a';
                free[i] = true;
            }
        }

        if (n == 0) {
            return String.join("", java.util.Collections.nCopies(L, "a"));
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (intervalEquals(word, str2, i, m)) {
                    boolean fixed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        int pos = i + j;
                        if (free[pos]) {
                            word[pos] = 'b';
                            free[pos] = false;
                            fixed = true;
                            break;
                        }
                    }
                    if (!fixed) {
                        return "";
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : word) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean intervalEquals(Character[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i + j] == null || word[i + j] != str2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}