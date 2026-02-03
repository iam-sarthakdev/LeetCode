class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, isConnected, vis);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int city, int[][] isConnected, boolean[] vis){
        vis[city] = true;
        for(int nextCity = 0; nextCity < isConnected.length; nextCity++){
            if(isConnected[city][nextCity] == 1 && !vis[nextCity]){
                dfs(nextCity, isConnected, vis);
            }
        }
    }
}