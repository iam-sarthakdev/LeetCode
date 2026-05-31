class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        TreeNode curr = root;

        if(root == null) return true;

        while(curr != null){
            if(curr.left == null){
                if(prev != null){
                    if(prev.val >= curr.val) return false;
                }
                prev = curr;
                curr = curr.right;
            }else{ // curr.left != null
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }else if(pred.right == curr){
                    pred.right = null;
                    if(prev != null){
                    if(prev.val >= curr.val) return false;
                }
                prev = curr;
                curr = curr.right;
                }
            }
        }
        return true;
    }
}