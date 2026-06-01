class Solution {
    int preIndex = 0;
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
       for(int i = 0; i < inorder.length; i++){
        inMap.put(inorder[i], i);
       }
       return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);

        root.left = helper(preorder, inStart, rootIndex -1);
        root.right = helper(preorder, rootIndex + 1, inEnd);
        return root;
    }
}