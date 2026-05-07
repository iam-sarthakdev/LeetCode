class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        backtrack(nums, isVisited, temp, res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] isVisited, List<Integer> temp, List<List<Integer>> res){
        
        //base case
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !isVisited[i - 1]) continue;
                        // self work
            if(!isVisited[i]){
                temp.add(nums[i]);
                isVisited[i] = true;

                backtrack(nums, isVisited, temp, res);

                // backtracking
                temp.remove(temp.size()-1);
                isVisited[i] = false;
            }
            }
    }
}