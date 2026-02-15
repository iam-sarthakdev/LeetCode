class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        char lastOp = '+';

        for(int i= 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch - '0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){

                if(lastOp == '+'){
                    st.push(currNum);
                }else if(lastOp == '-'){
                    st.push(-currNum);
                }else if(lastOp == '*'){
                    st.push(st.pop() * currNum);
                }else{
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                lastOp = ch;
            }
        }
        int ans = 0;
        for(int num : st){
            ans += num;
        }
        return ans;
    }
}