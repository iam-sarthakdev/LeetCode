class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        Set<String> set = new HashSet<>();
        for(String st : wordDict) set.add(st);
        return solve(0, s, wordDict, dp, set);
    }
    private boolean solve(int i, String s, List<String> wordDict, Boolean[] dp, Set<String> set){
    
        int n = s.length();
        if(i == n) return true;
        if(dp[i] != null) return dp[i];

        for(int j = i; j < n; j++){
            if(set.contains(s.substring(i, j+1))){
                if(solve(j + 1, s, wordDict, dp, set))
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}