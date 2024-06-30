class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int start = 0, end = 0;

        int maxOnes = 0;

        while (end < n) {
            if (nums[end] == 0) {
                k--;
            }

            while (k < 0 && start <= end) {
                k += (nums[start] == 0) ? 1 : 0;
                start++;
            }

            maxOnes = Math.max(end - start + 1, maxOnes);

            end++;
        }

        return maxOnes;
    }
}