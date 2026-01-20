class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
         backtrack(0, candidates, target, path, result);
         return result;
    }
    private void backtrack(int index, int[] candidates, int target, List<Integer> path, List<List<Integer>> result){
        // base case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return;

        
        for(int i = index; i < candidates.length; i++){
            // self work
            path.add(candidates[i]);

            backtrack(i, candidates, target - candidates[i], path, result);

            // backtracking
            path.remove(path.size() - 1);
        }
    }
}