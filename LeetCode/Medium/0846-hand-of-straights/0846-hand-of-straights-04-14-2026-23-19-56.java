class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(map.keySet());

        while(!minHeap.isEmpty()){
            int start = minHeap.peek();

            for(int i = 0; i < groupSize; i++){
                int curr = start + i;
                if(!map.containsKey(curr)) return false;

                map.put(curr, map.get(curr) - 1);

                if(map.get(curr) == 0){
                    map.remove(curr);

                    if(minHeap.peek() != curr) return false;

                    minHeap.poll();
                }
            }
        }
        return true;
    }
}