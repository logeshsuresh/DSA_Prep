class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        for (int[] point : points) {
            int x = point[0], y = point[1];
            double distanceFromOrigin = computeDistance(x, y);
            pq.offer(new Triplet(x, y, distanceFromOrigin));
            if (pq.size() > k) { pq.poll(); } 
        }

        int pqSize = pq.size();

        int[][] kClosestPoints = new int[pqSize][2];
        
        int idx = 0;

        while (!pq.isEmpty()) {
            kClosestPoints[idx][0] = pq.peek().x;
            kClosestPoints[idx][1] = pq.peek().y;
            idx++;
            pq.poll();
        }

        return kClosestPoints;
    }   

    private double computeDistance(int x, int y) { return Math.sqrt((x * x) + (y * y)); }  
}

class Triplet {
    int x;
    int y;
    double distance;
    public Triplet(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}