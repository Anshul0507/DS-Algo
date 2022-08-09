class Solution {
    int maxCost = 1000001;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m+1][target+1][n+1];
        int res = dfs(houses,cost,target,0,0,dp);
        if(res==maxCost)
            return -1;
        return res;
    }
    
    private int dfs(int[] houses, int[][] cost, int target, int i, int lastColour, int[][][] dp){
        if(i>=houses.length || target<0)
            return target==0 ? 0 : maxCost;
        if(dp[i][target][lastColour]>0)
            return dp[i][target][lastColour];
        if(houses[i]!=0)
            return dfs(houses,cost,target-((houses[i]==lastColour)?0:1),i+1,houses[i],dp);
        int res = maxCost;
        for (int clr = 1; clr <= cost[i].length; ++clr) {
            res = Math.min(res, cost[i][clr - 1] + dfs(houses, cost, target - ((lastColour != clr) ? 1 : 0), i+1, clr, dp));
        }
        dp[i][target][lastColour]=res;
        return res;
    }
}