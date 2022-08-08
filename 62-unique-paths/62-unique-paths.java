class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        return (int) nCr(m+n-2,Math.min(m-1,n-1));
    }
    
    private long nCr(int n, int r){
        if(r==1)
            return n;
        return (long) (n*nCr(n-1,r-1))/r;
    }
}