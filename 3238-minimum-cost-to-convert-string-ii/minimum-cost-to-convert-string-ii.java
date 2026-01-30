import java.util.*;

class Solution {
    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {
        int n = source.length();

        // Step 1: Collect all unique strings
        Map<String, Integer> idMap = new HashMap<>();
        int id = 0;

        for (String s : original) {
            if (!idMap.containsKey(s)) {
                idMap.put(s, id++);
            }
        }
        for (String s : changed) {
            if (!idMap.containsKey(s)) {
                idMap.put(s, id++);
            }
        }

        int m = idMap.size();
        long INF = (long) 1e18;

        // Step 2: Distance matrix for Floyd–Warshall
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Step 3: Fill direct transformation costs
        for (int i = 0; i < original.length; i++) {
            int u = idMap.get(original[i]);
            int v = idMap.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Step 4: Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        // Step 5: Group original strings by length
        Map<Integer, List<String>> byLength = new HashMap<>();
        for (String s : idMap.keySet()) {
            byLength.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
        }

        // Step 6: DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0; // base case

        for (int i = n - 1; i >= 0; i--) {

            // Option 1: characters match, move one step
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            // Option 2: try all substring transformations
            for (int len : byLength.keySet()) {
                if (i + len > n) continue;

                String sSub = source.substring(i, i + len);
                String tSub = target.substring(i, i + len);

                if (!idMap.containsKey(sSub) || !idMap.containsKey(tSub)) {
                    continue;
                }

                int u = idMap.get(sSub);
                int v = idMap.get(tSub);

                if (dist[u][v] == INF) continue;

                dp[i] = Math.min(
                        dp[i],
                        dist[u][v] + dp[i + len]
                );
            }
        }

        return dp[0] == INF ? -1 : dp[0];
    }
}
