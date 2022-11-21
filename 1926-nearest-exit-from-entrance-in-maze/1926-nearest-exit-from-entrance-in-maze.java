class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        int steps=0;
        q.add(entrance);
        maze[entrance[0]][entrance[1]]='+';
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cell = q.poll();
                if(endReached(cell,maze))
                    if(steps>0)
                        return steps;
                for(int k=0;k<4;k++){
                    int x = cell[0] + dx[k], y = cell[1] + dy[k];
                    if(isValid(x,y,maze)){
                        q.add(new int[]{x,y});
                        maze[x][y]='+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private boolean isValid(int x, int y, char[][] maze){
        if(x<0 || y<0 || x==maze.length || y==maze[0].length || maze[x][y]!='.')
            return false;
        return true;
    }
    
    private boolean endReached(int[] cell, char[][] maze){
        return cell[0]==0 || cell[0]==maze.length-1 || cell[1]==0 || cell[1]==maze[0].length-1;
    }
}