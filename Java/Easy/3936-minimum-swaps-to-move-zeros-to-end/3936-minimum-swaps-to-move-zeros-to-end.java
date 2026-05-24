class Solution {
    public int minimumSwaps(int[] nums) {
        int zeroes = 0;
        for(int n : nums){
            if(n == 0) zeroes++;
        }
        int targetlength = nums.length - zeroes;
        int swaps = 0;
        for(int i = 0; i < targetlength; i++){
            if(nums[i] == 0) swaps++;
        }
        return swaps;
    }
}