class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low = Math.max(0, low - 1);
                high--;
            }else{
                high++;
                low = Math.max(0, low - 1);
            }
        if(high < 0) return false;
        }

        return low == 0;
    }
}