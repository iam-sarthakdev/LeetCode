class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int ones = 0; // holds number appearing only 1 times
        int twos = 0; // holds number appearing 2 or more than 2 times

        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}