class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i > index && candidates[i] == candidates[i-1]) continue;
            // self work
            path.add(candidates[i]);

            backtrack(i + 1, candidates, target - candidates[i], path, result);

            // backtracking
            path.remove(path.size() - 1);
        }
    }
}