class Solution {
    class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;     // Initially every node is its own parent
                size[i] = 1;       // Initial size = 1
            }
        }

        // Find with Path Compression
        int findUPar(int node) {
            if (node == parent[node]) return node;

            parent[node] = findUPar(parent[node]);
            return parent[node];
        }

        // Union by Size
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

    static List<List<String>> accountsMerge(List<List<String>> details) {

        int n = details.size();

        Solution sol = new Solution();
        DisjointSet ds = sol.new DisjointSet(n);

        // Map email -> account index
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Step 1: Build DSU connections
        for (int i = 0; i < n; i++) {

            // Start from j=1 because j=0 is name
            for (int j = 1; j < details.get(i).size(); j++) {

                String mail = details.get(i).get(j);

                // If email not seen before → map it to this account
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                }
                else {
                    // If seen before → union current account with old one
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // Step 2: Prepare array to store merged emails
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        // Step 3: Group emails by ultimate parent
        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {

            String mail = entry.getKey();
            int node = ds.findUPar(entry.getValue());

            mergedMail[node].add(mail);
        }

        // Step 4: Build final answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].size() == 0) continue;

            // Sort emails
            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();

            // Add name first
            temp.add(details.get(i).get(0));

            // Add sorted emails
            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }

            ans.add(temp);
        }

        return ans;
    }
}
