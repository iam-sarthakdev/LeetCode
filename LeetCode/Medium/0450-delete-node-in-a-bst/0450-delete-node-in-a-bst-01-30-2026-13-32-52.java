class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{ // we are in the node we have to delete
            // we have 3 cases -> 0,1 or 2 child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }else{ // both child exists
                // Now find inorder predecessor
                int leftMax = findMax(root.left);
                root.val = leftMax;

                root.left = deleteNode(root.left, leftMax);
            }

            
        }
        return root;
    }
        public int findMax(TreeNode node){
            if(node.right != null){
                // TreeNode temp = node.right;
                while(node.right != null){
                node = node.right;
            }
            }
            return node.val;
            // return temp.val;
        }
}