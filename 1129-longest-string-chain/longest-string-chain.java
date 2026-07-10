class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxLen = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isPrecedence(words[j],words[i])){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    private boolean isPrecedence(String a, String b){
        if(b.length() != a.length() + 1) return false;

        int i = 0, j = 0;
        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i == a.length();
    }
}