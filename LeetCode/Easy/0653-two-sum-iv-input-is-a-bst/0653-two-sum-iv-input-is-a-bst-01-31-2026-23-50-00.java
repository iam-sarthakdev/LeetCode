class Solution {
    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        if(root == null) return false;

        inorder(root);

        int i = 0, j = list.size() -1;

        while(i < j){
            if((list.get(i) + list.get(j)) == k) return true;
            else if((list.get(i) + list.get(j)) == k) i++;
            else j--;
        }
        return false;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}