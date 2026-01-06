class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 1;
        int bestLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                bestLevel = level;
            }

            level++;
        }

        return bestLevel;
    }
}
