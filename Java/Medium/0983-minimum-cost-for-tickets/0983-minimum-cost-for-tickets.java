class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer[] dp = new Integer[n];
        return solve(0, days, costs, dp);
    }
    private int solve(int i, int[] days, int[] costs, Integer[] dp){
        int n = days.length;
        if(i >= n) return 0;

        if(dp[i] != null) return dp[i];

        // take 1 day pass
        int cost1 = costs[0] + solve(i + 1, days, costs, dp);

        // take 7 days pass
        int j = i;
        while(j < n && days[j] < 7 + days[i]){
            j++;
        }
        int cost7 = costs[1] + solve(j, days, costs, dp);
        // take 30 days pass
        j = i;
        while(j < n && days[j] < 30 + days[i]){
            j++;
        }
        int cost30 = costs[2] + solve(j, days, costs, dp);

        return dp[i] = Math.min(cost1, Math.min(cost7, cost30));
    }
}
    