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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) { return new ArrayList<>(); }

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean flag = true; // indicates the direction of traversing; true -> left to right & false -> right to left

        while (! queue.isEmpty()) {
            int n = queue.size();
            List<Integer> curNodes = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) { queue.offer(curNode.left); }
                if (curNode.right != null) { queue.offer(curNode.right); }
                curNodes.add(curNode.val);
            }
            if (flag) {
                res.add(new ArrayList<>(curNodes));
            } else {
                Collections.reverse(curNodes);
                res.add(new ArrayList<>(curNodes));
            }
            flag = !flag;
        }

        return res;

    }
}