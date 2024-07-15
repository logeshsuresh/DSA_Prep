class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        
        f(nums, 0, curSet, subsets);

        return subsets;
    }

    private void f(int[] nums, int idx, List<Integer> curSet, List<List<Integer>> subsets) {
        if (idx >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[idx]);
        f(nums, idx + 1, curSet, subsets);
        curSet.remove(curSet.size() - 1);
        f(nums, idx + 1, curSet, subsets);
    }
}