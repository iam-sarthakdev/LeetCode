class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1] , b[1]));

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while(!minHeap.isEmpty()){
            res[idx++] = minHeap.poll()[0];
        }
        return res;
    }
}