class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++){
                char s1 = s.charAt(i), s2=s.charAt(j);
                if(i==j)
                    dp[i][j]=1;
                else if(s1!=s2)
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                else if(i==j-1)
                    dp[i][j]=2;
                else
                    dp[i][j]=2 + dp[i+1][j-1];
            }
        return dp[0][n-1];
    }
}