class StockSpanner {
    Deque<int[]> st;
    public StockSpanner() {
        st = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!st.isEmpty() && st.peek()[0] <= price){
            span += st.pop()[1];
        }
        st.push(new int[] {price, span});
        return span;
    }
}
