class Point{
    int x;
    int y;
    int k;
    
    public Point(int x, int y, int k){
        this.x=x;
        this.y=y;
        this.k=k;
    }
}
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int shortestPath(int[][] grid, int k) {
        if(grid.length==1 && grid[0].length==1)
            return 0;
        if(k >= grid.length + grid[0].length - 1)
            return grid.length + grid[0].length - 2;
        int m = grid.length, n = grid[0].length, steps=0;
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,k));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1;i<=size;i++){
                Point curr = q.poll();
                if(curr.x==m-1 && curr.y==n-1)
                    return steps;
                for(int j=0;j<4;j++){
                    int x = curr.x+dx[j], y = curr.y+dy[j];
                    if(isValid(grid,x,y)){
                        if(grid[x][y]==0 && !isVisited(x,y,curr.k,visited)){
                            // System.out.println("Adding " + x + " " + y + " " + curr.k + " to q. Steps Before = " + steps + ". Predecessor = " + curr.x + " " + curr.y);
                            q.add(new Point(x,y,curr.k));
                        }

                        else if(curr.k>0 && grid[x][y]==1 && !isVisited(x,y,curr.k-1,visited)){
                            // System.out.println("Adding " + x + " " + y + " " + (curr.k-1) + " to q. Steps Before = " + steps + ". Decreasing by 1. Predecessor = " + curr.x + " " + curr.y);
                            q.add(new Point(x,y,curr.k-1));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private boolean isValid(int[][] grid, int x, int y){
        if(x<0 || y<0 || x==grid.length || y==grid[0].length)
            return false;
        return true;
    }
    
    private boolean isVisited(int x, int y, int k, boolean[][][] visited){
        if(visited[x][y][k])
            return true;
        visited[x][y][k]=true;
        return false;
    }
}