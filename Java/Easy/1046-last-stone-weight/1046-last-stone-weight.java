class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1){
        int y = maxHeap.poll();
        int x = maxHeap.poll();

        if(y != x){
            maxHeap.offer(y - x);
        }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}