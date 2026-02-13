import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.get(u).add(new int[]{v, cost});
        }

        // Step 2: Distance array (minimum cost to reach node)
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Queue stores {node, totalCost, stopsUsed}
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int node = curr[0];
            int costSoFar = curr[1];
            int stops = curr[2];

            // If stops exceed K, skip
            if (stops > K) continue;

            // Traverse all neighbors
            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int price = neighbor[1];

                int newCost = costSoFar + price;

                // Relaxation condition
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;

                    // Push next state with incremented stops
                    q.add(new int[]{nextNode, newCost, stops + 1});
                }
            }
        }

        // If destination not reachable
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
