class Solution {
    class Pair{
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> res = new TreeMap<>();

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                int hd = curr.hd;
                TreeNode node = curr.node;

                if(!levelMap.containsKey(hd)){
                    levelMap.put(hd, new ArrayList<>());
                }
                levelMap.get(hd).add(node.val);

                if(node.left != null) q.add(new Pair(node.left, hd - 1));
                if(node.right != null) q.add(new Pair(node.right, hd + 1));
            }
            for(int key : levelMap.keySet()){
                List<Integer> temp = levelMap.get(key);
                Collections.sort(temp);

                    if(!res.containsKey(key)){
                    res.put(key, new ArrayList<>());
                }
                res.get(key).addAll(temp);  
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> value : res.values()){
            ans.add(value);
        }
        return ans;
    }
}