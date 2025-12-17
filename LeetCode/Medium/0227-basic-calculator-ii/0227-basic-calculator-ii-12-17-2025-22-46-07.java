class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        char lastOperator = '+';

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1 ){

                if(lastOperator == '+'){
                    st.push(currNum);
                }else if(lastOperator == '-'){
                    st.push(-currNum);
                }else if(lastOperator == '*'){
                    st.push(currNum * st.pop());
                }else{
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                lastOperator = ch;
            }
        }
        int result = 0;
        for(int n : st){
            result += n;
        }
        return result;
    }
}