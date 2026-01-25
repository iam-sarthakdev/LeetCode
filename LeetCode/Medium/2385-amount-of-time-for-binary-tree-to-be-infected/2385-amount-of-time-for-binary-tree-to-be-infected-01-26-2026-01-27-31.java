class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(); 
        makeMap(root, parentMap);
        Set<TreeNode> isVisited = new HashSet<>(); // to mark infeted nodes
        int minutes = -1;
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode startNode = startNode(root, start);

        isVisited.add(startNode);
        q.offer(startNode);

        while(q.size() > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null && !isVisited.contains(temp.left)){
                    q.offer(temp.left);
                    isVisited.add(temp.left);
                }
                if(temp.right != null && !isVisited.contains(temp.right)){
                    q.offer(temp.right);
                    isVisited.add(temp.right);
                }
                // now process the parent node
                if(parentMap.containsKey(temp) && !isVisited.contains(parentMap.get(temp))){
                    q.add(parentMap.get(temp));
                    isVisited.add(parentMap.get(temp));
                }
            }
            minutes++;
        }

        return minutes;
        
        
    }
    private void makeMap(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null) return;
        if(root.left != null) parentMap.put(root.left, root);
        if(root.right != null) parentMap.put(root.right, root);
        makeMap(root.left, parentMap);
        makeMap(root.right, parentMap);
    }
    private TreeNode startNode(TreeNode root, int start){
        if(root == null) return null;
        if(root.val == start) return root;
        TreeNode left = startNode(root.left, start);
        if(left != null) return left;
        else return startNode(root.right, start);
    }
}