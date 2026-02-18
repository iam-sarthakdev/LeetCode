class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        makeList(root, list);
        return made(0, list.size()-1, root, list);

    }
    private void makeList(TreeNode root, List<Integer> list){
        if(root == null) return;
        makeList(root.left, list);
        list.add(root.val);
        makeList(root.right, list);
    }

    private TreeNode made(int left, int right, TreeNode root, List<Integer> list){

        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = made(left, mid - 1, root, list);
        node.right = made(mid + 1, right, root, list);

        return node;
    }
}