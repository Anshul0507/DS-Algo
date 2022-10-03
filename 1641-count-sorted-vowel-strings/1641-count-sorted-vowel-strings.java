class Solution {
    public int countVowelStrings(int n) {
        if(n==1)
            return 5;
        int[][] dp = new int[n][5];
        for(int i=0;i<5;i++)
            dp[0][i]=1;
        int prevSum = 5;
        for(int i=1;i<n;i++){
            int currSum=0;
            for(int j=0;j<5;j++){
                dp[i][j]=prevSum;
                prevSum-=dp[i-1][j];
                currSum+=dp[i][j];
            }
            prevSum=currSum;
        }
        return prevSum;
    }
}