class Solution {
    List<TreeNode> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        
        inorder(root);

        return build(0, nodes.size() - 1);
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        nodes.add(root);

        inorder(root.right);
    }
    private TreeNode build(int left, int right){
        
        if(left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode root = nodes.get(mid);

        root.left = build(left, mid -1);
        root.right = build(mid + 1, right);

        return root;
    }
}