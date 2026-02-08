class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
            else{
                // closing
                if(!st.isEmpty()){
                    char top = st.pop();
                    if(c == ')' && top != '(') return false;
                    else if(c == ']' && top != '[') return false;
                    else if(c == '}' && top != '{') return false;
                }else{ // stack is empty
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}