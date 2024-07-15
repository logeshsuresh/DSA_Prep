class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int curSum = 0;

        List<Integer> curSet = new ArrayList<>();

        List<List<Integer>> subsets = new ArrayList<>();

        f(candidates, 0, target, curSum, curSet, subsets);

        return subsets;
    }

    private void f(int[] candidates, int idx, int target, int curSum, List<Integer> curSet, List<List<Integer>> subsets) {
        if (curSum > target) { return; }

        if (idx >= candidates.length) {
            if (curSum == target) {
                subsets.add(new ArrayList<>(curSet));
            }
            return;
        }

        curSum += candidates[idx];
        curSet.add(candidates[idx]);
        f(candidates, idx, target, curSum, curSet, subsets);
        curSum -= candidates[idx];
        curSet.remove(curSet.size() - 1);
        f(candidates, idx + 1, target, curSum, curSet, subsets);
    }
}