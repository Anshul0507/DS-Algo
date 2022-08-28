class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length,n=mat[0].length,d=m+n-1,k=0;
        while(k<d){
            int i = (k<n)?0:k-n+1;
            int j = (k>=n)?0:n-k-1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while(i<m && j<n){
                pq.add(mat[i++][j++]);
            }
            i = (k<n)?0:k-n+1;
            j = (k>=n)?0:n-k-1;
            while(i<m && j<n){
                mat[i++][j++] = pq.poll();
            }
            k++;
        }
        return mat;
    }
}