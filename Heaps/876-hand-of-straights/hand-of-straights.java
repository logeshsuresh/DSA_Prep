
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) { return false; }

        Map<Integer, Integer> numCount = new HashMap<>();

        for (int num : hand) { numCount.put(num, numCount.getOrDefault(num, 0) + 1); }

        PriorityQueue<Integer> pq = new PriorityQueue<>(numCount.keySet());

        while (!pq.isEmpty()) {
            int curNum = pq.peek();
            numCount.put(curNum, numCount.get(curNum) - 1);
            if (numCount.get(curNum) == 0) { 
                numCount.remove(curNum);
                pq.poll();
            }
            for (int i = 1; i < groupSize; i++) {
                int nextNum = curNum + i;
                if (!numCount.containsKey(nextNum)) { return false; }
                numCount.put(nextNum, numCount.get(nextNum) - 1);
                if (numCount.get(nextNum) == 0) {
                    if (pq.peek() != nextNum) { return false; }
                    pq.poll();
                    numCount.remove(nextNum);
                }
            }
        }

        return true;
    }
}
