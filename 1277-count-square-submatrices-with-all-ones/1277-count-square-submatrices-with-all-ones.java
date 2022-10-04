class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, s = Math.min(m,n);
        int count = 0;
        int[][][] dp = new int[m][n][s];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                int curr = Math.min(i,j);
                for(int k=0;k<=curr;k++){
                    if(matrix[i][j]==0)
                        dp[i][j][k]=0;
                    else if(k==0)
                        dp[i][j][k]=1;
                    else if(k<=i && k<=j && dp[i-1][j-1][k-1]>0 && dp[i-1][j][k-1]>0 && dp[i][j-1][k-1]>0)
                        dp[i][j][k]=1;
                    count+=dp[i][j][k];
                }
            }
        return count;
    }
}