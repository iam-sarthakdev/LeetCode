class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length-1;
        while(i<= j){
            int leftSq = nums[i] * nums[i];
            int rightSq = nums[j] * nums[j];
            if(leftSq > rightSq){
                ans[k--] = leftSq;
                i++;
            }else{
                ans[k--] = rightSq;
                j--;
            }
        }
        return ans;
    }
}