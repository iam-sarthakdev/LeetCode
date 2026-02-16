class Solution {
    class DisjointSet{
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

            if(pv == pu) return;

            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }

        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        int edgesUsed = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            int pu = ds.find(u);
            int pv = ds.find(v);

            if(pu == pv){
                extraEdges++;
            }else{
                ds.union(u,v);
                edgesUsed++;
            }   
        }
        int nodesUsed = edgesUsed + 1;
        int remainingNodes = n - nodesUsed;
        return extraEdges >= remainingNodes ? remainingNodes : -1;
        
    }
}