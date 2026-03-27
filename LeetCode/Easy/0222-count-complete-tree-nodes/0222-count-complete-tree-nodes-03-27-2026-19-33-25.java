class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getLeft(root);
        int rightHeight = getRight(root);

        if(leftHeight == rightHeight){
            return (1 << leftHeight)-1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int getLeft(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    private int getRight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
}