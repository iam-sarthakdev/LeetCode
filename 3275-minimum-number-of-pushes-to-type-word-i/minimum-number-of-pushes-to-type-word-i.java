class Solution {
    public int minimumPushes(String word) {
        int ans = 8;
        int len = word.length();
        if(len <= 8) return len;
        else if(len > 8){
            for(int i = 8; i < Math.min(len, 16); i++){
                ans += 2;
            }
            for(int i = 16; i < Math.min(len, 24); i++){
                ans += 3;
            }
            for(int i = 24; i < Math.min(len, 26); i++){
                ans += 4;
            }

        }
        return ans;
    }
}