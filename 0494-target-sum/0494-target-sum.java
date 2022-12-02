class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, zerosCount = 0, S=0;
        for(int i =0;i<n;i++){
            if(nums[i]==0)
                zerosCount++;
            else
                S+=nums[i];
        }
        //sum(P) - sum(N) = target
        //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        //2 * sum(P) = target + sum(nums)
        // target + S(total) should be even
        if((S+target)%2==1 ||(S+target)<0)
            return 0;
        //target = S(positives)
        target = (S+target)/2;
        int[][] dp = new int[n][target+1];
        for(int i= 0;i<n;i++)
            for(int j=0;j<=target;j++){
                if(j==0)
                    dp[i][j]=1;
                else if(i==0)
                    dp[i][j]=j==nums[i]?1:0; // there is no way to make a positive target when current num is 0
                else if(nums[i]==0 || nums[i]>j)
                    dp[i][j]=dp[i-1][j]; //not possible to select current elemet if it is greater than target
                else
                    dp[i][j]=dp[i-1][j-nums[i]] + dp[i-1][j]; //select current ways + not select current ways
            }
        return dp[n-1][target]*(int)Math.pow(2,zerosCount);
    }
}