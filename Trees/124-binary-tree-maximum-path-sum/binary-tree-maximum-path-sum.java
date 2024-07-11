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
    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = new int[1];
        maxPathSum[0] = Integer.MIN_VALUE;
        f(root, maxPathSum);
        return maxPathSum[0];
    }

    private int f(TreeNode root, int[] maxPathSum) {
        if (root == null) { return 0; }

        int leftSum = Math.max(f(root.left, maxPathSum), 0);
        int rightSum = Math.max(f(root.right, maxPathSum), 0);

        maxPathSum[0] = Math.max(maxPathSum[0], leftSum + rightSum + root.val);

        return root.val  + Math.max(leftSum, rightSum);

    }
}