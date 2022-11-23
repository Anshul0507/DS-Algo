class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int time=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==2)
                    q.add(new Point(i,j));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Point p = q.poll();
                for(int k=0;k<4;k++){
                    int x = p.x+dx[k], y = p.y+dy[k];
                    if(isFresh(x,y,grid)){
                        q.add(new Point(x,y));
                        grid[x][y]=2;
                    }
                }
            }
            if(!q.isEmpty())
                time++;
        }
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==1)
                    return -1;
        return time;
    }
    
    private boolean isFresh(int x, int y, int[][] grid){
        if(x<0 || y<0 || x==grid.length || y== grid[0].length ||grid[x][y]!=1)
            return false;
        return true;
    }
}