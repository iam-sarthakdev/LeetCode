class Solution {
    long maxIndex = 0;
    long minIndex = 0;
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode node, long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        long maxWidth = 0;

        q.offer(new Pair(root, 1)); // root has index 1

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                long index = curr.index;

                if(node.left != null)q.offer(new Pair(node.left, index * 2));
                if(node.right != null)q.offer(new Pair(node.right, (index * 2) + 1));

                if(i == 0){
                    minIndex = curr.index;
                }
                if(i == size - 1){
                    maxIndex = curr.index;
                }

                maxWidth = Math.max(maxWidth, maxIndex - minIndex + 1);
            }
        }
        return (int)maxWidth;
    }
}