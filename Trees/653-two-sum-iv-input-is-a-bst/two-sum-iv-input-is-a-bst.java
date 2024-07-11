/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> numSet = new HashSet<>();
        boolean res = f(root, numSet, k);
        return res;
    }

    private boolean f(TreeNode root, Set<Integer> numSet, int k) {
        if (root == null) { return false; }

        if (numSet.contains(k - root.val)) { return true; }

        numSet.add(root.val);
        
        boolean left = f(root.left, numSet, k);
        boolean right = f(root.right, numSet, k);

        return left || right;
    }
}
