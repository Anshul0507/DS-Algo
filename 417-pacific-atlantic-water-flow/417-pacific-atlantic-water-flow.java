class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            dfs(pacific,heights,-1,i,0);
            dfs(atlantic,heights,-1,i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(pacific,heights,-1,0,j);
            dfs(atlantic,heights,-1,m-1,j);
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
            }
        return res;
    }
    
    private void dfs(boolean[][] vis, int[][] heights, int currHeight, int x, int y){
        if(x<0 || y<0 || x==heights.length || y==heights[0].length || vis[x][y] || currHeight>heights[x][y])
            return;
        vis[x][y]=true;
        for(int i=0;i<4;i++){
            dfs(vis,heights,heights[x][y],x+dx[i],y+dy[i]);
        }
    }
}