class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] == nums[i]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}