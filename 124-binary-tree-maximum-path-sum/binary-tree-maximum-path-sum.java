class Solution {
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    public int maxPathSum(TreeNode root) {
        height(root);
        return maxSum;
    }
        private int height(TreeNode root){
        if(root == null) return 0;

        int leftSum = height(root.left); // collect all left path sum
        int rightSum = height(root.right); // collect all right path sum

        if(leftSum < 0) leftSum = 0;
        if(rightSum < 0) rightSum = 0;



        int splitPath = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, splitPath);

        return root.val + Math.max(leftSum, rightSum);     
    }
}