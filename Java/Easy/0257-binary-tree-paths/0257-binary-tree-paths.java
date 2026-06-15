/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        bfs(root, res, "");
        return res;
        
    }

    private void bfs(TreeNode root, List<String> res, String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            s += root.val;
            res.add(s);
            return;
        }
        bfs(root.left, res, s + root.val + "->");
        bfs(root.right, res, s + root.val + "->");
    }

}