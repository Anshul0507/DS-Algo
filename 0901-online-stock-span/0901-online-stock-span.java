class StockSpanner {
    
    Stack<Pair<Integer,Integer>> st;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index=0;
    }
    
    public int next(int price) {
        index++;
        int ans;
        while(!st.empty() && price>=st.peek().getValue())
            st.pop();
        if(st.isEmpty())
            ans = index;
        else
            ans = index-st.peek().getKey();
        st.add(new Pair(index,price));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */