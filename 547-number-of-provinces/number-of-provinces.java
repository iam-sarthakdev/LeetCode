class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] vis = new boolean[n];
        for(int cities = 0; cities < n; cities++){
           if(!vis[cities]){
            dfs(cities, isConnected,vis);
            provinces++;
           }
        }
        return provinces;
    }

    private void dfs(int city, int[][] isConnected, boolean[] vis){
        for(int nextCity = 0; nextCity < isConnected.length; nextCity++){
            vis[city] = true;
            if(isConnected[city][nextCity] == 1 && !vis[nextCity]){
                dfs(nextCity, isConnected, vis);
            }
        }
    }
}