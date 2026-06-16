class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] curr = new int[2];

        // if i rob the root
        curr[1] = root.val + left[0] + right[0];

        // if i dont rob this node
        curr[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);

        return curr;
    }
}