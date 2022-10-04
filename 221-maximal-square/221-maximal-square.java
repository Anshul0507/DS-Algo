class Solution {
    public int maximalSquare(char[][] A) {
        int maxArea=maxFromSides(A);
        int m = A.length, n = A[0].length;
        if(m==1 || n==1)
            return maxArea;
        int[][] dp = new int[m][n];
        createDp(A,dp);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (dp[i][j] > 0) {
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1;
                }
                maxArea = Math.max(maxArea,dp[i][j]*dp[i][j]);
            }
        }
        return maxArea;
    }
    
    private void createDp(char[][] A, int[][] dp){
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                dp[i][j]=(A[i][j]=='1')?1:0;
            }
        }
    }
    
    private int maxFromSides(char[][] A){
        for(int i = 0; i < A.length; ++i)
            if(A[i][0]=='1')
                return 1;
        for(int i = 1; i < A[0].length; ++i)
            if(A[0][i]=='1')
                return 1;
        return 0;
    }
    
    private int min(int a, int b, int c){
        if(a<=b && a<=c)
            return a;
        if(b<=c)
            return b;
        return c;
    }
}