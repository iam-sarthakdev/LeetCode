class Solution {
    static class DisjointSet{
        int[] parent;
        int[] size;
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
            public int find(int node){
                if(parent[node] == node) return node;
                return parent[node] = find(parent[node]);
            }
            public void union(int u, int v){
                int pu = find(u);
                int pv = find(v);

                if(pu == pv) return;

                if(size[pu] < size[pv]){
                    parent[pu] = pv;
                    size[pv] += pu;
                }else{
                    parent[pv] = pu;
                    size[pu] += pv;
                }
            }
        }
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int n = edges.length;
        DisjointSet dsu = new DisjointSet(n+1);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u) == dsu.find(v)){
                res[0] = u;
                res[1] = v;
            }else{
                dsu.union(u, v);
            }
        }
        return res;
    }
}