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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = f(preorder, inorder, 0, n-1, 0, n-1, inMap);

        return root;   
        
    }

    private TreeNode f(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) { return null; }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIdx = inMap.get(preorder[preStart]);

        int leftElements = rootIdx - inStart;

        root.left = f(preorder, inorder, preStart + 1, preStart + leftElements, inStart, rootIdx - 1, inMap);
        root.right = f(preorder, inorder, preStart + leftElements + 1, preEnd, rootIdx + 1, inEnd, inMap);

        return root;
    }
}