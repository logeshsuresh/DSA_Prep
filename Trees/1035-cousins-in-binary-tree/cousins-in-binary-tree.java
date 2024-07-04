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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, null));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, TreeNode> nodeParentMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.curNode;
                if (node.val == x || node.val == y) {
                    nodeParentMap.put(node.val, p.parent);
                }
                if (node.left != null) { queue.add(new Pair(node.left, node)); }
                if (node.right != null) { queue.add(new Pair(node.right, node)); }
            }
            if (nodeParentMap.containsKey(x) && nodeParentMap.containsKey(y)) {
                int parentOfX = nodeParentMap.get(x).val;
                int parentOfY = nodeParentMap.get(y).val;
                if (parentOfX != parentOfY) { return true; }
            }
        }

        return false;
    }
}

class Pair {
    TreeNode curNode;
    TreeNode parent;
    public Pair(TreeNode curNode, TreeNode parent) {
        this.curNode = curNode;
        this.parent = parent;
    }
}