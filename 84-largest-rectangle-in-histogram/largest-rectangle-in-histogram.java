class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        // build nse
        nse[n - 1] = n;
        st.push(n-1);

        for(int i = n-2; i>=0; i--){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i] = st.peek();
            }
            else if(st.isEmpty()){
                nse[i] = n;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        // build nse
        pse[0] = -1;
        st.push(0);

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i] = st.peek();
            }
            else if(st.isEmpty()){
                pse[i] = -1;
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int width = nse[i] - pse[i] - 1;
            int height = heights[i];
            int area = width * height;
            maxArea = Math.max(area, maxArea);
        } 
        return maxArea;

    }
}