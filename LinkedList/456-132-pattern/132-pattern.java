class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        
        Stack<Integer> stack = new Stack<>();
        // 132 pattern -> third => 2 in 132 pattern
        int third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i --) {
            // if i encounter an element which is smaller than my third (in 132) -> return true
            if (nums[i] < third) { return true; }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                // monotonically decr stack
                // encounter an element greater than stak peek 
                // consider nums[i] -> (3) and (2) as max of third & stack.pop()
                third = Math.max(third, stack.pop());
            }
            // keep push the element to stack
            stack.push(nums[i]);
        }
        
        return false;
    }
}