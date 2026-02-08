class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }
    private int pathSum(TreeNode root){
        if(root == null) return 0;

        int leftSum = pathSum(root.left);
        if(leftSum < 0) leftSum = 0;
        int rightSum = pathSum(root.right);
        if(rightSum < 0) rightSum = 0;

        maxSum = Math.max(maxSum, (root.val + leftSum + rightSum));

        return root.val + Math.max(leftSum, rightSum);
    }
}