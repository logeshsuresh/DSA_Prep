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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) { return true; }
        boolean isSymmetric = check(root.left, root.right);
        return isSymmetric;
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) { return true; }

        if (left == null && right != null || left != null && right == null || left.val != right.val) { return false; }

        return check(left.left, right.right) && check(left.right, right.left);
    }
}