class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> perm = new ArrayList<>();

        List<List<Integer>> permutations = new ArrayList<>(); 

        Set<Integer> visited = new HashSet<>();

        f(nums, 0, visited, perm, permutations);

        return permutations;
    }

    private void f(int[] nums, int idx, Set<Integer> visited, List<Integer> perm, List<List<Integer>> permutations) {
        if (idx >= nums.length) {
            permutations.add(new ArrayList<>(perm));
            return;
        }

        for (int num : nums) {
            if (!visited.contains(num)) {
                perm.add(num);
                visited.add(num);
                f(nums, idx + 1, visited, perm, permutations);
                perm.remove(perm.size() -1);
                visited.remove(num);
            }
        }
    }
}