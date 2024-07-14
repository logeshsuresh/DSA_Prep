class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // balance the heaps [maxHeap can be greater than minHeap only by size 1]
        if (maxHeap.size() > minHeap.size() + 1) { // maxHeap.size() > minHeap.size() + 1 -> [Eg : maxHeap.size() = 3 & minHeap.size() = 1]
            minHeap.offer(maxHeap.poll());
        } else  if (minHeap.size() > maxHeap.size()) { // [minHeap size should not be greater than maxHeap size]
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int s1 = maxHeap.size();
        int s2 = minHeap.size();
        if (s1 == s2) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return Double.valueOf(maxHeap.peek());
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
