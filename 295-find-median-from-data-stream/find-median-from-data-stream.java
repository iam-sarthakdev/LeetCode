class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){ // odd elements
        return maxHeap.peek();
        }else
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}