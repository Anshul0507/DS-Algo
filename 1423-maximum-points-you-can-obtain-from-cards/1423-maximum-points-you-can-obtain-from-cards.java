class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int s = 0, p1 = k-1, n = cardPoints.length;
        for(int i=0; i<k;i++)
            s+=cardPoints[i];
        int maxSoFar = s;
        while(p1>=0){
            s = s - cardPoints[p1] + cardPoints[n-k+p1];
            maxSoFar = Math.max(maxSoFar,s);
            p1--;
        }
        return maxSoFar;
    }
}