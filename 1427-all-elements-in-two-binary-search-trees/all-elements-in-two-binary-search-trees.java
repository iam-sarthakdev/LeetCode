class Solution {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2){
        inorder1(root1);
        inorder2(root2);
        merge(list1, list2);
        return res;
    }
        private void inorder1(TreeNode root){
            if(root == null)return;

            inorder1(root.left);
            list1.add(root.val);
            inorder1(root.right);
        }
        private void inorder2(TreeNode root){
            if(root == null)return;

            inorder2(root.left);
            list2.add(root.val);
            inorder2(root.right);
        }

        private void merge(List<Integer> list1, List<Integer> list2){
            int i = 0, j = 0;
            while(i < list1.size() && j < list2.size()){
                if(list1.get(i) < list2.get(j)){
                    res.add(list1.get(i++));
                }else{
                    res.add(list2.get(j++));
                }
            }
            while(i < list1.size()){
                res.add(list1.get(i++));
            }
            while(j < list2.size()){
                res.add(list2.get(j++));
            }
        }
}