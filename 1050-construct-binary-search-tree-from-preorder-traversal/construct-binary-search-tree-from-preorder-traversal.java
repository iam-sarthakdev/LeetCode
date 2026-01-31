class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        for(int i = 1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;

    }
    private TreeNode insert(TreeNode root, int val){
        if(root == null) return null;

        if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
            }else{
                insert(root.left, val);
            }
        }else{ // value greater
            if(root.right == null){
                root.right = new TreeNode(val);
            }else{
                insert(root.right, val);
            }
        }
        return root;
    }
}