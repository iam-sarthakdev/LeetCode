class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0, maxLen = 0, i = 0, j = 0;

        while(j < nums.length){
            if(nums[j] == 0) zeroCount++;

            while(zeroCount > k){
                if(nums[i] == 0)zeroCount--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}