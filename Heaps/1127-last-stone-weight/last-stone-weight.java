class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) pq.offer(stone);

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            int diff = first - second;
            if (diff > 0) { pq.offer(diff); }
        }

        int lastStoneWt = (pq.isEmpty()) ? 0 : pq.poll();

        return lastStoneWt;
    }
}