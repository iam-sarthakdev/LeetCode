class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        // create pse
        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // make nse

        for(int i = n-1; i >=0; i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            long contribution = (left * right) % MOD * arr[i] % MOD;
            ans += contribution % MOD;
        }
        return (int) ans;
    }
}