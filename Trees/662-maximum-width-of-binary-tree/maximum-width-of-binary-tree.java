class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstPos = -1, lastPos = -1;
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                if (firstPos == -1) {
                    firstPos = p.nodeNum;
                    lastPos = p.nodeNum;
                } else {
                    lastPos = p.nodeNum;
                }
                if (p.node.left != null) { queue.offer(new Pair(p.nodeNum * 2, p.node.left)); }
                if (p.node.right != null) { queue.offer(new Pair(p.nodeNum * 2 + 1, p.node.right)); }
            }
            maxWidth = Math.max(maxWidth, lastPos - firstPos + 1);
        }

        return maxWidth;
    }
}

class Pair {
    int nodeNum;
    TreeNode node;
    public Pair(int nodeNum, TreeNode node) {
        this.nodeNum = nodeNum;
        this.node = node;
    }
}