class Solution {
    class Pair{
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        long maxWidth = 0;
        long maxWid = 0;
        long minWid = 0;

        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                long idx = curr.idx;

                if(i == 0){
                    minWid = idx;
                }
                if(i == size - 1){
                    maxWid = idx;
                }

                maxWidth = Math.max(maxWidth, maxWid - minWid + 1);

                if(node.left != null) q.add(new Pair(node.left, 2*idx));
                if(node.right != null) q.add(new Pair(node.right, 2*idx+1));
            }
        }
        return (int)maxWidth;
    }
}