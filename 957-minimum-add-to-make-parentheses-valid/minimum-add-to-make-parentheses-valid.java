class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int minMoves = 0;

        for(char c : s.toCharArray()){
            if(c == '('){ // just push into stacks
            st.push(c);
            }else{ // c is ')'
            if(st.isEmpty()){
                minMoves++;
            }else{ // stack is not empty
            if(!st.isEmpty() && st.peek() == '('){
                st.pop();
            }
            }
            }
        }
        minMoves += st.size();
        return minMoves;
    }
}