class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(j > i){
            if(nums[i]%2 != 0){
                swap(nums, i, j);
                j--;
            }else{
                i++;
            }
        }
        return nums;
    }
    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}