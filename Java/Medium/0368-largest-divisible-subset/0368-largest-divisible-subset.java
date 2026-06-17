class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] dp = new int[n];      // dp[i] = length of largest subset ending at i
        int[] parent = new int[n];  // for backtracking the actual subset
        
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        int maxLen = 1, maxIdx = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Since sorted, nums[i] >= nums[j], so only check nums[i] % nums[j]
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        
        // Backtrack to reconstruct the subset
        List<Integer> result = new ArrayList<>();
        for (int i = maxIdx; i != -1; i = parent[i]) {
            result.add(nums[i]);
        }
        
        return result;
    }
}