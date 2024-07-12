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
class BSTIterator {

    List<TreeNode> inorder;
    int idx = 0;

    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        computeInorder(root, inorder);
    }
    
    public int next() {
        int element = inorder.get(idx).val;
        idx++;
        return element;
    }
    
    public boolean hasNext() {
        return idx < inorder.size();
    }

    private void computeInorder(TreeNode root, List<TreeNode> inorder) {
        if (root == null) { return; }

        computeInorder(root.left, inorder);
        inorder.add(root);
        computeInorder(root.right, inorder);

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */