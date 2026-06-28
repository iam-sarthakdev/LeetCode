class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] < 0){
                res[j++] = Math.abs(nums[i]);
            }else{
                nums[idx] = -nums[idx];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) res[j] = i+1;
        }
        return res;
    }
}