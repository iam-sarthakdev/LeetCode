class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }

    private int pathSum(TreeNode root){
        if(root == null) return 0;

        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);

        if(leftSum < 0) leftSum = 0;
        if(rightSum < 0) rightSum = 0;

        int zigZagPathSum = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum , zigZagPathSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}