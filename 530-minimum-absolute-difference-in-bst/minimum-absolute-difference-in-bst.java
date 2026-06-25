class Solution {
        int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
                inorder(root);
        return min;
    }
        private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        if(prev != null){
            int diff = Math.abs(root.val - prev.val);
            min = Math.min(min, diff);
        }
        prev = root;
        inorder(root.right);
    }
}