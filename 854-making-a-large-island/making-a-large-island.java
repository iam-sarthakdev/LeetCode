import java.util.*;

class Solution {

    // ----------- Disjoint Set Class -----------
    class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;     // each node is its own parent
                size[i] = 1;       // initial component size = 1
            }
        }

        // Find with path compression
        int findUPar(int node) {
            if (parent[node] == node)
                return node;

            parent[node] = findUPar(parent[node]);
            return parent[node];
        }

        // Union by size
        void unionBySize(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);

            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    // Helper to check boundaries
    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        // Total nodes = n*n
        DisjointSet ds = new DisjointSet(n * n);

        // Directions (4 sides)
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        // -------------------------
        // Step 1: Connect all 1s
        // -------------------------
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // Skip water
                if (grid[row][col] == 0)
                    continue;

                for (int ind = 0; ind < 4; ind++) {

                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    // If valid and neighbor is land
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {

                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;

                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // -------------------------
        // Step 2: Try flipping each 0
        // -------------------------
        int mx = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1)
                    continue;  // only flip zeros

                HashSet<Integer> components = new HashSet<>();

                // Check all 4 neighbors
                for (int ind = 0; ind < 4; ind++) {

                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {

                        int parent = ds.findUPar(newr * n + newc);
                        components.add(parent);  // unique components
                    }
                }

                int sizeTotal = 0;

                // Sum sizes of unique components
                for (int parent : components) {
                    sizeTotal += ds.size[parent];
                }

                // +1 because we flip current zero
                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        // -------------------------
        // Step 3: Edge case
        // If grid contains no zero
        // -------------------------
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            int parent = ds.findUPar(cellNo);
            mx = Math.max(mx, ds.size[parent]);
        }

        return mx;
    }
}
