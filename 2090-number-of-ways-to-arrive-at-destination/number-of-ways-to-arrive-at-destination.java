class Solution {

    public int countPaths(int n, int[][] roads) {

        int MOD = (int)1e9 + 7;

        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;  // source is node 0

        long[] ways = new long[n];
        ways[0] = 1;  // one way to reach source

        // Step 4: Min heap -> {distance, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        pq.add(new long[]{0, 0});

        while(!pq.isEmpty()) {

            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];

            // Skip outdated entries
            if(currDist > dist[node]) continue;

            for(long[] neighbor : adj.get(node)) {

                int nextNode = (int) neighbor[0];
                long weight = neighbor[1];

                long newDist = currDist + weight;

                // Case 1: Found strictly shorter path
                if(newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;

                    // Copy ways (because new shortest path found)
                    ways[nextNode] = ways[node];

                    pq.add(new long[]{newDist, nextNode});
                }

                // Case 2: Found another path with same shortest distance
                else if(newDist == dist[nextNode]) {

                    // Add ways
                    ways[nextNode] = 
                        (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        // Answer = number of shortest ways to reach last node
        return (int)(ways[n - 1] % MOD);
    }
}
