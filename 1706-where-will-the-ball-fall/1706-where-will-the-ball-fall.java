class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for(int j=0;j<n;j++){
            int currIdx = j,i;
            for(i=0;i<m;i++){
                if(grid[i][currIdx]==1){
                    if(currIdx==n-1){
                        res[j]=-1;
                        break;
                    }
                    if(currIdx<n-1 && grid[i][currIdx+1]==-1){
                        res[j]=-1;
                        break;
                    }
                    currIdx++;
                }
                else{
                    if(currIdx==0){
                        res[j]=-1;
                        break;
                    }
                    if(currIdx>0 && grid[i][currIdx-1]==1){
                        res[j]=-1;
                        break;
                    }
                    currIdx--;
                }
            }
            if(i==m)
                res[j]=currIdx;
        }
        return res;
    }
}