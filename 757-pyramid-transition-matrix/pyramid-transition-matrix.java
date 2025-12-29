import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return dfs(bottom, "", 0, map);
    }

    private boolean dfs(String cur, String next, int idx, Map<String, List<Character>> map) {
        if (cur.length() == 1) return true;
        if (idx == cur.length() - 1) {
            return dfs(next, "", 0, map);
        }
        String key = cur.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;
        for (char c : map.get(key)) {
            if (dfs(cur, next + c, idx + 1, map)) return true;
        }
        return false;
    }
}