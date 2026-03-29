class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        return xor;
    }
}