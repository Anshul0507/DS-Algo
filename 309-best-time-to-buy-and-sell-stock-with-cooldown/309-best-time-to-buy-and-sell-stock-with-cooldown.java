class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1)
            return 0;
        int[] rest = new int[n];
        int[] buy = new int[n];
        int[] sell = new int[n];
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            rest[i] = Math.max(rest[i-1],sell[i-1]);
            buy[i] = Math.max(buy[i-1], rest[i-1]-prices[i]);
            sell[i] = buy[i-1] + prices[i];
        }
        return Math.max(rest[n-1],sell[n-1]);
    }
}