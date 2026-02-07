class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!bfsCheck(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfsCheck(int start, int[][] graph, int[] color){
        Queue<Integer> q = new ArrayDeque<>();

        color[start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < graph[node].length; i++){
                int neigh = graph[node][i];
                if(color[neigh] == -1){
                    color[neigh] = 1 - color[node];
                    q.add(graph[node][i]);
                }else if(color[neigh] == color[node]) return false;
            }
        }
        return true;
    }
}