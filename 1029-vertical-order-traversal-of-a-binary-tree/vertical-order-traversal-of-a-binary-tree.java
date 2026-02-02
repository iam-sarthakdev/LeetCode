class Solution {

    class Pair{
        TreeNode node; 
        int col;

        Pair(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer, List<Integer>> colMap = new HashMap<>();

            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                int col = curr.col;
                TreeNode temp = curr.node;

                if(!colMap.containsKey(col)){
                    colMap.put(col, new ArrayList<>());
                }
                colMap.get(col).add(temp.val);

                if(temp.left != null) q.add(new Pair(temp.left, col - 1));
                if(temp.right != null) q.add(new Pair(temp.right, col + 1));
            }
            // current level finish, now sort the values in map and add in main map
            for(int col : colMap.keySet()){
                List<Integer> values = colMap.get(col);
                Collections.sort(values);
                if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).addAll(values);
            }    
        }
        // now convert the values of the main map to an arraylist
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> values : map.values()){
            res.add(values);
        }
        return res;
    }
}