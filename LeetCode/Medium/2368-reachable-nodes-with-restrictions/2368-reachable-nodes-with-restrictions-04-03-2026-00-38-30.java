class Solution {
    public int reachableNodes(int n, int[][] edges, int[] r) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println(map);
        boolean vis[]=new boolean[n];
        HashSet<Integer>res=new HashSet<>();
        for(int i=0;i<r.length;i++){
            res.add(r[i]);
        }   
        dfs(0,map,vis,res);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]){
                cnt++;
                System.out.println(i);
            }
        }
        return cnt;
    }
    public static void dfs(int src,HashMap<Integer,ArrayList<Integer>> map,boolean vis[],HashSet<Integer>res){
        vis[src]=true;
        for(int nbrs:map.get(src)){
            if(!vis[nbrs]){
                if(!res.contains(nbrs)){
                    dfs(nbrs,map,vis,res);
                }
            }
        }
    }
}