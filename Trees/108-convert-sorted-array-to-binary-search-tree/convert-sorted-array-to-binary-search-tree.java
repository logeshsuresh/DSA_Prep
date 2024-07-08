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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = f(nums, 0, n - 1);
        return root;
    }

    private TreeNode f(int[] nums, int i, int j) {
        if (i > j) { return null; }

        int mid = i + (j - i) / 2;
        TreeNode curRoot = new TreeNode(nums[mid]);
        curRoot.left = f(nums, i, mid - 1);
        curRoot.right = f(nums, mid + 1, j);

        return curRoot;
    }
}
