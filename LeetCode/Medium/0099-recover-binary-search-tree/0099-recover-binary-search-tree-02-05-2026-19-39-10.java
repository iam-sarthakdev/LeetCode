class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                if(prev != null && prev.val > curr.val){
                        if(first == null) first = prev;
                        second = curr;      
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
                }else{
                    pred.right = null;
                    if(prev != null && prev.val > curr.val){
                        if(first == null) first = prev;
                        second = curr;      
                    }
                prev = curr;
                curr = curr.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}