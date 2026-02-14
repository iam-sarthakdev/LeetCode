class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] neigh : edges){
            int u = neigh[0];
            int v = neigh[1];
            int wt = neigh[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        int ans = -1;
        int minCity = Integer.MAX_VALUE;

        for(int city = 0; city < n; city++){
            int[] dist = dijkstra(city, adj, n);

            int reachableCity = 0;
            for(int i = 0; i < n; i++){
                if(i != city && dist[i] <= distanceThreshold){
                    reachableCity++;
                }
            }

            if(reachableCity <= minCity){
                minCity = reachableCity;
                ans = city;
            }
        }
        return ans;
    }
    private int[] dijkstra(int src, ArrayList<ArrayList<int[]>> adj, int n){
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            pq.add(new int[]{0, src});

            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int currDist = curr[0];
                int node = curr[1];

                for(int[] neigh : adj.get(node)){
                    int nextNode = neigh[0];
                    int cost = neigh[1];

                    if(currDist + cost < dist[nextNode]){
                        dist[nextNode] = currDist + cost;
                        pq.add(new int[]{dist[nextNode], nextNode});
                    }
                }
            }
            return dist;
    }
}