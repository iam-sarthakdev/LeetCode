class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return DFS(root, 0);
    }

    public int DFS(TreeNode root, int x) {
        if (root==null) return 0;
        x = x*2 + root.val;
        if(root.left==root.right) return x;
        return DFS(root.left, x) + DFS(root.right, x);
    }
}