class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
             return 0;
        int n = prices.length;
        int[][] dp = new int[3][n];
        for(int i=1;i<=2;i++){
            int maxTemp = -prices[0];
            for(int j=1; j<prices.length;j++){
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxTemp);
                maxTemp=Math.max(maxTemp,dp[i-1][j-1]-prices[j]);
            }
        }
        return dp[2][n-1];
    }
    
    private int quickSolve(int[] prices){
        int profit=0;
        for(int i=1;i<prices.length;i++)
            if(prices[i]>prices[i-1])
                profit = profit + prices[i]-prices[i-1];
        return profit;
    }
}