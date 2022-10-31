class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length==1 || matrix[0].length==1)
            return true;
        int m = matrix.length, n = matrix[0].length;
        for(int i=m-2;i>=0;i--){
            int curr = matrix[i][0], row = i+1;
            for(int j=1;j<n && row<m;j++,row++){
                if(matrix[row][j]!=curr)
                    return false;
            }
        }
        for(int j=1;j<n-1;j++){
            int curr = matrix[0][j], col = j+1;
            for(int i=1;i<m && col<n; i++,col++){
                if(matrix[i][col]!=curr)
                    return false;
            }
        }
        return true;
    }
}