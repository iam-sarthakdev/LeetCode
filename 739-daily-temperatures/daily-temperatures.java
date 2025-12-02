class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        int n = temperatures.length;
        st.push(n-1);
        ans[n-1] = 0;

        for(int i = n-2; i >= 0; i--){

            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek() - i;
            }
            else if(st.isEmpty()) ans[i] = 0;
            st.push(i);
        }
        return ans;
    }
}