class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node,
                     int remainingSum,
                     List<Integer> path) {

        // Base case: reached beyond leaf
        if (node == null) return;

        // 1️⃣ Choose: include current node in the path
        path.add(node.val);

        // 2️⃣ Check: if it's a leaf and sum matches, save the path
        if (node.left == null && node.right == null) {
            if (remainingSum == node.val) {
                // Must add a COPY because 'path' will be modified later
                res.add(new ArrayList<>(path));
            }
        } else {
            // 3️⃣ Explore: go deeper with updated remaining sum
            dfs(node.left, remainingSum - node.val, path);
            dfs(node.right, remainingSum - node.val, path);
        }

        // 4️⃣ Un-choose (Backtrack):
        // Remove current node before returning to parent
        path.remove(path.size() - 1);
    }
}
