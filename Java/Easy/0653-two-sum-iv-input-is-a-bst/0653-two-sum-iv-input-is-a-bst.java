class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
       
        if(root == null) return false;

        inorder(root);

        int i = 0, j = list.size() -1;

        while(i < j){
            int sum = list.get(i) + list.get(j);
            if(sum == k) return true;
            else if(sum < k) i++;
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