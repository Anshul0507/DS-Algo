class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, zerosCount = 0, S=0;
        for(int i =0;i<n;i++){
            if(nums[i]==0)
                zerosCount++;
            else
                S+=nums[i];
        }
        if((S+target)%2==1 ||(S+target)<0)
            return 0;
        target = (S+target)/2;
        int[][] dp = new int[n+1][target+1];
        dp[0][0]=1;
        for(int i= 0;i<=n;i++)
            for(int j=0;j<=target;j++){
                if(j==0)
                    dp[i][j]=1;
                else if(i==0)
                    dp[i][j]=0;
                else if(nums[i-1]==0 || nums[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j-nums[i-1]] + dp[i-1][j];
            }
        return (int) Math.pow(2,zerosCount)*dp[n][target];
    }
    
    private int ways(int[]a, int n, int idx, int prevSum, int target){
        if(idx==n){
            if(prevSum == target)
                return 1;
            return 0;
        }
        return ways(a,n,idx+1,prevSum + a[idx], target) + 
            ways(a,n,idx+1,prevSum - a[idx], target);
    }
}