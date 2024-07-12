/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) { 
            return f(root, q, p);
        } else {
            return f(root, p, q);
        }
    }

    private TreeNode f(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { return root; }

        if (root.val >= p.val && root.val <= q.val) { 
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return f(root.left, p, q);
        } else {
            return f(root.right, p, q);
        }

    }
}