class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            else if(ch == '['){
                strStack.push(curr.toString());
                curr.setLength(0);
                numStack.push(num);
                num = 0;
            }
            else if(ch == ']'){
                int repeat = numStack.pop();
                String prev = strStack.pop();
                StringBuilder repeated = new StringBuilder(prev);

                for(int j = 0; j < repeat; j++){
                    repeated.append(curr);
                }
                curr = repeated;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}