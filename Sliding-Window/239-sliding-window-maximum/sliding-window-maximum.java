class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Pair> dq = new LinkedList<>();

        int start = 0, end = 0;

        int[] winMax = new int[n - k + 1];
        int idx = 0;

        while (end < n) {
            int val = nums[end];

            while (end - start + 1 > k && start <= end) {
               if (!dq.isEmpty() && dq.peekFirst().val == nums[start] && dq.peekFirst().index == start) {
                dq.removeFirst();
               }
               start ++;
            }

           while (!dq.isEmpty() && val >= dq.getLast().val) {
                dq.removeLast();
            }
            
            dq.addLast(new Pair(end ,val));
        
            if (end - start + 1 == k) {
                winMax[idx] = (dq.getFirst().val);
                idx ++;
            }

            end ++;
        }

        return winMax;
    }
}

class Pair {
    int index;
    int val;
    public Pair(int index, int val) {
        this.index = index;
        this.val = val;
    }
}