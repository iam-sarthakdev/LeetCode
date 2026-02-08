class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!dfsCheck(i, graph, color)) return false;
            }
        }
        return true;
    }
    private boolean dfsCheck(int start, int[][] graph, int[] color){

        for(int i = 0; i < graph[start].length; i++){
            int neigh = graph[start][i];
            if(color[neigh] == -1){
                color[neigh] = 1- color[start];
                dfsCheck(neigh, graph, color);
            }else if(color[start] == color[neigh]) return false;
        }
        return true;
    }
}