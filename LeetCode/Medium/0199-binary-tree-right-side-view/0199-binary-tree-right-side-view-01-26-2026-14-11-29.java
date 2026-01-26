class Solution {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root, res);
    }

    public List<Integer> bfs(TreeNode root, List<Integer> res){
        if(root == null) return res;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();

                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                if(i == size - 1){
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}