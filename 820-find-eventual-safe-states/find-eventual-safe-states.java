class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] safe = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, graph, vis, pathVis, safe);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(safe[i]){
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int node, int[][] graph,  boolean[] vis,  boolean[] pathVis,  boolean[] safe){
        vis[node] = true;
        pathVis[node] = true;

        for(int neigh : graph[node]){
            if(!vis[neigh]){
                if(dfs(neigh, graph, vis, pathVis, safe)) return true;
            }else if(pathVis[neigh]) return true;
        }

        pathVis[node] = false;
        safe[node] = true;
        return false;
    }
}