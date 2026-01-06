class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int correctIndex = Math.abs(nums[i]) - 1;

            if(nums[correctIndex] > 0){
                nums[correctIndex] = -nums[correctIndex];
            }else{
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }
}