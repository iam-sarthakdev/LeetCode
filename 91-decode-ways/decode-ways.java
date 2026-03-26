class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int next1 = 1;
        int next2 = 0;
        int curr = 0;

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                curr = 0;
            }else{
                curr = 0;
                // single partition
                curr += next1;

                // 2 digit partition if valid
                if(i + 1 < n){
                    int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
                    if(num >= 10 && num <= 26){
                        curr += next2;
                    }
                }
            }
            next2 = next1;
            next1 = curr;
        }
        return next1;
    }
}