class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int ans = -1;
        int minReachable = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }

        for(int city = 0; city < n; city++){
            int[] dist = dijkstra(city, adj, n);

            int cities = 0;
            for(int i = 0; i < n; i++){
                if(dist[i] <= distanceThreshold && i != city){
                    cities++;
                }
            }
                if(cities <= minReachable){
                    ans = city;
                    minReachable = cities;
                }
        }
        return ans;
    }
    private int[] dijkstra(int src, ArrayList<ArrayList<int[]>> adj, int n){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.add(new int[]{0, src});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int dis = curr[0];
            int node = curr[1];

            if(dist[node] < dis) continue;

            for(int[] neigh : adj.get(node)){
                int nextNode = neigh[0];
                int cost = neigh[1];

                if(cost + dis < dist[nextNode]){
                    dist[nextNode] = cost + dis;
                    pq.add(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist;
    }
}