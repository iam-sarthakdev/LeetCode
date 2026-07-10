class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // dp[i][j] = LCS length between
        // first i chars of str1 and first j chars of str2
        int[][] dp = new int[n+1][m+1];

        // Build LCS table
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];

                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Build SCS by traversing the table
        StringBuilder ans = new StringBuilder();

        int i = n;
        int j = m;

        while(i>0 && j>0){

            // characters match → part of both strings
            if(str1.charAt(i-1)==str2.charAt(j-1)){

                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }

            // move towards larger LCS value
            else if(dp[i-1][j] > dp[i][j-1]){

                ans.append(str1.charAt(i-1));
                i--;
            }
            else{

                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        // append remaining characters
        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }

        // reverse since we built it backwards
        return ans.reverse().toString();
    }
}