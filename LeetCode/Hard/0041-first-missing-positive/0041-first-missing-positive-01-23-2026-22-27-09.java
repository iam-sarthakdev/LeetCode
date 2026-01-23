class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Step 1: Place each number at its correct index if possible
        while (i < n) {
            int correctIndex = nums[i] - 1;

            /*
             Conditions to swap:
             1. nums[i] should be in range [1, n]
             2. nums[i] should not already be at its correct position
            */
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                // swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++; // move forward if no swap needed
            }
        }

        // Step 2: Find the first index where number is incorrect
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        // Step 3: If all positions are correct
        return n + 1;
    }
}
