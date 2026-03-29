class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, 0, temp);
        return res;
    }
    private void backtrack(int[] nums, int index, List<Integer> temp){
        // base case 
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // self work
       // case 1 : include 
       temp.add(nums[index]);
       backtrack(nums, index + 1, temp);

       // case 2: exclude 
       temp.remove(temp.size() - 1);
       backtrack(nums, index + 1, temp);
    }
}