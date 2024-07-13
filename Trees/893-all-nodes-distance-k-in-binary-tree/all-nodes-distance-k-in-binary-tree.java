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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> nodeAtKDist = new ArrayList<>();

        Map<Integer, List<Integer>> nodeNei = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        nodeNei.put(root.val, new ArrayList<>());

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                List<Integer> nei = nodeNei.get(curNode.val);
                if (curNode.left != null) {
                    nei.add(curNode.left.val);
                    nodeNei.put(curNode.val, nei);
                    List<Integer> leftNei = new ArrayList<>();
                    leftNei.add(curNode.val);
                    nodeNei.put(curNode.left.val, leftNei);
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nei.add(curNode.right.val);
                    nodeNei.put(curNode.val, nei);
                    List<Integer> rightNei = new ArrayList<>();
                    rightNei.add(curNode.val);
                    nodeNei.put(curNode.right.val, rightNei);
                    queue.offer(curNode.right);
                }
            }
        }
        
        computeNodesAtKDist(nodeNei, target.val, k, nodeAtKDist);

        return nodeAtKDist;
    }

    private void computeNodesAtKDist(Map<Integer, List<Integer>> nodeNei, int target, int k, List<Integer> nodesAtKDist) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        
        vis.add(target);
        queue.offer(target);

        while (k > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curVal = queue.poll();
                for (int nei : nodeNei.get(curVal)) {
                    if (!vis.contains(nei)) {
                        vis.add(nei);
                        queue.offer(nei);
                    }
                }
            }
            k--;
        }

        while (!queue.isEmpty()) {
            nodesAtKDist.add(queue.poll());
        }
    }
}
