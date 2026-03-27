class Solution {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return 1 + left + right;
    }
}