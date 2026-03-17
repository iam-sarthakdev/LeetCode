class Solution {

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        // add boundaries 0 and n
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;

        // copy cuts
        for(int i = 0; i < m; i++){
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        // dp[i][j] → min cost between cuts[i] and cuts[j]
        int[][] dp = new int[m + 2][m + 2];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, m + 1, newCuts, dp);
    }

    private int solve(int i, int j, int[] cuts, int[][] dp){

        // no cut possible
        if(j - i <= 1)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        // try every cut between i and j
        for(int k = i + 1; k < j; k++){

            int left = solve(i, k, cuts, dp);
            int right = solve(k, j, cuts, dp);

            // cost of current cut
            int cost = cuts[j] - cuts[i];

            int total = left + right + cost;

            minCost = Math.min(minCost, total);
        }

        return dp[i][j] = minCost;
    }
}