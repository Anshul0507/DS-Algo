class Solution {
    public boolean makesquare(int[] m) {
        int n = m.length;
        if(n<4)
            return false;
        int P=0, maxi=-1;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,m[i]);
            P+=m[i];
        }
        if(P%4!=0)
            return false;
        int side = P/4;
        if(maxi>side)
            return false;
        Arrays.sort(m);
        int[] sides = {side,side,side,side};
        return makesquareHelper(n-1,m,sides,side);
    }
    
    private boolean makesquareHelper(int i, int[] m, int[] sides, int side){
        if(i==-1)
            return sides[0]==sides[1] && sides[0]==sides[2] && sides[0]==sides[3];
        for(int x=0;x<4;x++){
            if(sides[x]<m[i])
                continue;
            sides[x]-=m[i];
            if(makesquareHelper(i-1,m,sides,side))
                return true;
            sides[x]+=m[i];
            if(sides[x]==side)
                break;
        }
        return false;
    }
}