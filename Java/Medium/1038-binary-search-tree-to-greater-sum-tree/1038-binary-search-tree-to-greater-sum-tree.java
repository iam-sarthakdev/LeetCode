class Solution {
    int prefixSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        return postorder(root);
    }
    private TreeNode postorder(TreeNode root){
        if(root == null) return null;

        postorder(root.right);

        root.val += prefixSum;
        prefixSum = root.val;

        postorder(root.left);

        return root;
    }
}