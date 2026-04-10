class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int num1 = st.pop();
                int num2 = st.pop();
                int result;
                if(s.equals("+")) result = num2 + num1;
                else if(s.equals("-")) result = num2 - num1;
                else if(s.equals("*")) result = num2 * num1;
                else  result = num2 / num1;
                st.push(result);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}