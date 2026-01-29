class Solution {
     Set<TreeNode> isVisited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        buildMap(root, parentMap);
        int dist = -1;
       
         
        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);
        isVisited.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null && !isVisited.contains(temp.left)){
                    q.add(temp.left);
                    isVisited.add(temp.left);
                }
                if(temp.right != null && !isVisited.contains(temp.right)){
                    q.add(temp.right);
                    isVisited.add(temp.right);
                }
                // add parent
                if(parentMap.containsKey(temp) && !isVisited.contains(parentMap.get(temp))){
                    q.add(parentMap.get(temp));
                    isVisited.add(parentMap.get(temp));
                }
                if(dist == k) res.add(temp.val);
            }
        }
        return res;
    }

    private void buildMap(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null) return;

        if(root.left != null) parentMap.put(root.left, root);
        if(root.right != null) parentMap.put(root.right, root);

        buildMap(root.left, parentMap);
        buildMap(root.right, parentMap);
    }

}