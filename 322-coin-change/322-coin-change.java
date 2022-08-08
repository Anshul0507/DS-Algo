class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        Arrays.sort(coins);
        int M = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            for(int j=0;j<=amount;j++)
                dp[i][j]=M;
        for(int j=1; j<=amount;j++)
            if(j%coins[0]==0)
                dp[0][j]=j/coins[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                if(j%coins[i]==0)
                    dp[i][j]=j/coins[i];
                else if(j>=coins[i] && dp[i][j-coins[i]]!=M)
                    dp[i][j]=Math.min(1+dp[i][j-coins[i]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n-1][amount]==M?-1:dp[n-1][amount];
    }
}