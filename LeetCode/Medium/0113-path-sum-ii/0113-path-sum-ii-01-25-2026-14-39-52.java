class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        helper(root, targetSum, paths, res);
        return res;   
    }

            private void helper(TreeNode root, int targetSum, List<Integer> paths, List<List<Integer>> res){
            if(root == null) return; // base case
            if(root.left == null && root.right == null){ // base case
            if(root.val == targetSum){
                paths.add(root.val);
                res.add(new ArrayList<>(paths));
                paths.remove(paths.size() - 1);
                return;
            }
        }
        // paths.remove(paths.size() - 1);
        paths.add(root.val);
        helper(root.left, targetSum - root.val, paths, res);
        helper(root.right, targetSum - root.val, paths, res);

        paths.remove(paths.size() - 1);
    }
}