class Solution {
    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        preorder(root);
        return minDiff;
    }
    private void preorder(TreeNode root){
        if(root == null) return;

        preorder(root.left);

        if(prev != null){
            diff = root.val - prev.val;
        }
        prev = root;
        minDiff = Math.min(minDiff, diff);

        preorder(root.right);
    }
}