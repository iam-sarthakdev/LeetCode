class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev1 = 0;
        int prev2 = 0;

        for(int num : nums){
            int robCurr = num + prev2;
            int skipCurr = prev1;

            int curr = Math.max(robCurr, skipCurr);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}