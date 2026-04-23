class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        boolean leftToRight = true;
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            Deque<Integer> level = new ArrayDeque<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.peek();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null)q.offer(temp.right);
                if(leftToRight) level.offerLast(q.poll().val);
                else if(!leftToRight) level.offerFirst(q.poll().val);
            }
            res.add(new ArrayList<>(level));
            leftToRight = !leftToRight;
        }
        return res;
    }
}