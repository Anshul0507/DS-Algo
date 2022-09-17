class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return false;
        int target=0;
        for(int i=0;i<n;i++)
            target+=nums[i];
        if(target%2==1)
            return false;
        target /= 2;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(j==0)
                    dp[i][j]=true;
                else if (i==0)
                    dp[i][j]=false;
                else if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][target];
    }
}