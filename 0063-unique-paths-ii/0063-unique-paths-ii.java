class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return 0;
        grid[0][0]=1;
        for(int i=1;i<m;i++){
            if(grid[i][0]==1){
                while(i<m)
                    grid[i++][0]=0;
                break;
            }   
            grid[i][0]=1;
        }
        for(int j=1;j<n;j++){
            if(grid[0][j]==1){
                while(j<n)
                    grid[0][j++]=0;
                break;
            }
            grid[0][j]=1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]==1)
                    grid[i][j]=0;
                else
                    grid[i][j]=grid[i-1][j] + grid[i][j-1];
                // System.out.print(grid[i][j] + " ");
            }
            // System.out.println();
        }
        return grid[m-1][n-1];
    }
}