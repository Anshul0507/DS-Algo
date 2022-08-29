class Solution {
    int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count ++;
                }
            }
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid){
        if(i==-1 || j==-1 || i==grid.length || j==grid[0].length || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        for(int k=0;k<4;k++)
            dfs(i+dx[k],j+dy[k],grid);
    }
}