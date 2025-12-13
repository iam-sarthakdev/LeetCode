import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> valid = new ArrayList<>();
        Set<String> allowed = Set.of("electronics", "grocery", "pharmacy", "restaurant");

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && allowed.contains(businessLine[i]) && isValid(code[i])) {
                valid.add(i);
            }
        }

        valid.sort((a, b) -> {
            int cmp = businessLine[a].compareTo(businessLine[b]);
            if (cmp != 0) return cmp;
            return code[a].compareTo(code[b]);
        });

        List<String> ans = new ArrayList<>();
        for (int idx : valid) {
            ans.add(code[idx]);
        }
        return ans;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }
}
