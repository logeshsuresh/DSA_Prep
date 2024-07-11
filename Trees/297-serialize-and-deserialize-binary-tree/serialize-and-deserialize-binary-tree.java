/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        constructPreorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> serializedData = new ArrayList<>(List.of(data.split(",")));
        Collections.reverse(serializedData);
        TreeNode root = reconstructTree(serializedData);
        return root;
    }

    private void constructPreorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('$');
            sb.append(',');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        constructPreorder(root.left, sb);
        constructPreorder(root.right, sb);
    }

    private TreeNode reconstructTree(List<String> serializedData) {
        if (serializedData.isEmpty()) { return null; }

        String lastElement = serializedData.remove(serializedData.size() - 1);

        if (lastElement.equals("$")) { return null; }

        TreeNode curNode = new TreeNode(Integer.parseInt(lastElement));
        
        curNode.left = reconstructTree(serializedData);
        curNode.right = reconstructTree(serializedData);

        return curNode;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));