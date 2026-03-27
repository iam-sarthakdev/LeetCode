class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    private int solve(TreeNode root){
        if(root == null) return 0;

        int leftSum = solve(root.left);
        if(leftSum < 0) leftSum = 0;
        int rightSum = solve(root.right);
        if(rightSum < 0) rightSum = 0;

        int zigzagSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, zigzagSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}