class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Step 1: Reverse graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }

        // outdegree array (original graph)
        int[] outdegree = new int[n];

        // Build reversed graph and outdegree
        for (int u = 0; u < n; u++) {
            outdegree[u] = graph[u].length;  // original outdegree

            for (int v : graph[u]) {
                // reverse edge: v -> u
                revAdj.get(v).add(u);
            }
        }

        // Step 2: Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Step 3: Add all terminal nodes (outdegree = 0)
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: BFS (Kahn’s style)
        boolean[] safe = new boolean[n]; // marks safe nodes

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true; // this node is safe

            for (int parent : revAdj.get(node)) {
                outdegree[parent]--;

                if (outdegree[parent] == 0) {
                    q.add(parent);
                }
            }
        }

        // Step 5: Collect all safe nodes in sorted order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
