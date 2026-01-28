public class Codec {

    // -------- SERIALIZE --------
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    // Helper DFS function
    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        // If node is null, store marker and return
        if (node == null) {
            sb.append("N,");
            return;
        }

        // Store current node value
        sb.append(node.val).append(",");

        // Serialize left subtree
        dfsSerialize(node.left, sb);

        // Serialize right subtree
        dfsSerialize(node.right, sb);
    }

    // -------- DESERIALIZE --------
    public TreeNode deserialize(String data) {
        // Split serialized string into tokens
        String[] arr = data.split(",");
        int[] idx = new int[1]; // acts like a pointer
        return dfsDeserialize(arr, idx);
    }

    // Helper DFS function
    private TreeNode dfsDeserialize(String[] arr, int[] idx) {
        // If we see null marker, move index and return null
        if (arr[idx[0]].equals("N")) {
            idx[0]++;
            return null;
        }

        // Create node with current value
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;

        // Build left and right subtrees
        node.left = dfsDeserialize(arr, idx);
        node.right = dfsDeserialize(arr, idx);

        return node;
    }
}
