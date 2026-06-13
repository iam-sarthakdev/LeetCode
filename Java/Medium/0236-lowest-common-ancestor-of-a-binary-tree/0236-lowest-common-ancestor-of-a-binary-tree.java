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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == q) return p;
        if(p == root || q == root)return root;

        // boolean pInLeft = inLeft(root.left, p);
        // boolean qInLeft = inLeft(root.left, q);

        if(inLeft(root.left, p) && inLeft(root.left, q)) return lowestCommonAncestor(root.left, p,q);
        else if(!inLeft(root.left, p) && !inLeft(root.left,q)) return lowestCommonAncestor(root.right, p,q);
        else return root;
    }

    private boolean inLeft(TreeNode root, TreeNode node){
        if(root == null) return false;
        if(root == node) return true;
        return inLeft(root.left, node) || inLeft(root.right, node);
    }
}