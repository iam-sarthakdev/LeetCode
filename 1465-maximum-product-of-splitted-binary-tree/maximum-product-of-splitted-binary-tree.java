class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // 1st DFS: get total sum of the tree
        totalSum = getTotalSum(root);

        // 2nd DFS: compute subtree sums and maximize product
        computeSubtreeSum(root);

        return (int) (maxProduct % MOD);
    }

    // DFS to compute total sum
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // DFS to compute subtree sums and update max product
    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = computeSubtreeSum(node.left);
        long right = computeSubtreeSum(node.right);

        long subtreeSum = node.val + left + right;

        // Try splitting here
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
