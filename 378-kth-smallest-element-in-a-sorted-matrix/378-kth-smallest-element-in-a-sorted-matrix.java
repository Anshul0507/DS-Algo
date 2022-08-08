class Solution {
    public int kthSmallest(int[][] a, int k) {
        int n = a.length, l = a[0][0],h = a[n-1][n-1];
        while(l<h){
            int mid = l+ (h-l)/2;
            int midRank = getRank(a,mid);
            if(midRank<k)
                l=mid+1;
            else
                h=mid;
        }
        return l;
    }
    private int getRank(int[][] a, int t){
        int count = 0,n=a.length, i = n-1, j=0;
        while(i>=0 && j<n){
            if(a[i][j]>t)
                i--;
            else{
                count +=i+1;
                j++;
            }
        }
        return count;
    }
}