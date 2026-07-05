class Solution {

    class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if (parent[node] != node)
                parent[node] = find(parent[node]); // path compression
            return parent[node];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            // union by size
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;

        // Step 1: Find maximum row and column
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Offset to separate row and column nodes
        int offset = maxRow + 1;

        // Total DSU size
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        // To track which nodes are actually used
        HashSet<Integer> usedNodes = new HashSet<>();

        // Step 2: Union row and column nodes
        for (int[] stone : stones) {

            int rowNode = stone[0];
            int colNode = stone[1] + offset;

            ds.union(rowNode, colNode);

            usedNodes.add(rowNode);
            usedNodes.add(colNode);
        }

        // Step 3: Count number of connected components
        int components = 0;

        for (int node : usedNodes) {
            if (ds.find(node) == node) {
                components++;
            }
        }

        // Step 4: Result
        return stones.length - components;
    }
}
