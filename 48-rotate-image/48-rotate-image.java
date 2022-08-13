class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        mirrorImage(matrix);
    }
    
    private void transpose(int[][] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr[0].length;j++)
                swap(arr,i,j,j,i);
    }
    
    private void mirrorImage(int[][] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length/2;j++)
                swap(arr,i,j,i,arr[0].length-j-1);
    }
    
    private void swap(int[][] arr, int i, int j, int x, int y){
        int temp = arr[i][j];
        arr[i][j] = arr[x][y];
        arr[x][y] = temp;
    }
}