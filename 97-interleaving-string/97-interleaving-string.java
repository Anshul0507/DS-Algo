class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m+n!=s3.length())
            return false;
        boolean[][] dp= new boolean[m+1][n+1];
        boolean flag=false;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(j==0)
                    dp[i][0]=dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
                else if(i==0)
                    dp[0][j]=dp[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
                else
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) ||
                    (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
                flag = flag || dp[i][j];
            }
            if(!flag)
                return false;
        }
        return dp[m][n];
    }
}