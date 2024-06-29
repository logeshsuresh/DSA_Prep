class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int start = 0, end = 0;

        long curSum = 0;
        int maxFreq = 0;

        while (end < n) {
            curSum += nums[end];

            while ((long) nums[end] * (end - start + 1) > (curSum + k) && start <= end) {
                curSum -= nums[start];
                start++;
            }

            maxFreq = Math.max(maxFreq, end - start + 1);

            end++;
        }

        return maxFreq;
    }
}
