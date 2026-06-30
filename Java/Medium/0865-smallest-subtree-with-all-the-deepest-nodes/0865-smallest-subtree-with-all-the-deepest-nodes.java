/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    // Helper class to store (node, depth)
    private static class Info {
        TreeNode node;
        int depth;
        
        Info(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
    
    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(null, 0);
        }
        
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);
        
        if (leftInfo.depth > rightInfo.depth) {
            return new Info(leftInfo.node, leftInfo.depth + 1);
        }
        if (rightInfo.depth > leftInfo.depth) {
            return new Info(rightInfo.node, rightInfo.depth + 1);
        }
        
        // depths equal → this node is LCA of all deepest
        return new Info(root, leftInfo.depth + 1);
    }
}
