class Solution {
    public int countSquares(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = min(A[i-1][j-1], A[i-1][j], A[i][j-1])+1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
    
    private int min(int a,int b, int c){
        if(a<=b && a<=c)
            return a;
        if(b<=c)
            return b;
        return c;
    }
}