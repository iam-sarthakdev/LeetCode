class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time > dist[node]) continue;

            for(int[] neigh : adj.get(node)){
                int nextNode = neigh[0];
                int timeTaken = neigh[1];

                int newTime = time + timeTaken;
                if(newTime < dist[nextNode]){
                    dist[nextNode] = newTime;
                    pq.add(new int[]{newTime, nextNode});
                }
            }
        }
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1; // can reach every node
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}