class Solution {
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum){
        map.put(0L, 1);
        return dfs(root, targetSum, 0L);
        
    }
    private int dfs(TreeNode root, int targetSum, long currSum){
        int count = 0;
        if(root == null) return 0;

        currSum += root.val;

        if(map.containsKey(currSum - targetSum)){
            count += map.get(currSum - targetSum);
        }
        map.put(currSum, map.getOrDefault(currSum, 0)+1);

        count += dfs(root.left, targetSum, currSum);
        count += dfs(root.right, targetSum, currSum);

        map.put(currSum, map.get(currSum)-1);

        return count;

    }
}