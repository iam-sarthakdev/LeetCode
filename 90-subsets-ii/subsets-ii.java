class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        backtrack(0, nums,temp);
        return res;
    }
    private void backtrack(int start, int[] nums, List<Integer> temp){
        // base case 
       
            res.add(new ArrayList<>(temp));

            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i - 1]) continue;
        // self work
       // case 1 : include 
       temp.add(nums[i]);
       backtrack(i + 1, nums,temp);

       // case 2: exclude 
       temp.remove(temp.size() - 1);
    //    backtrack(nums,temp);
            }
    }
}