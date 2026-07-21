class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n == 0) return new int[0];
        int suffix = 1;
        int[] result = new int[n];

        result[0] = nums[0];
        for(int i = 1; i < n; i++){
            result[i] = result[i-1] * nums[i];
        }

        for(int i = n-1; i >= 1; i--){
            result[i] = result[i-1] * suffix;
            suffix *= nums[i];
        }
        result[0] = suffix;
        return result;
    }
}