class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0, cost=0;
        while(i<colors.length()){
            int maxi=neededTime[i],sum=neededTime[i];
            while(i<colors.length()-1 && colors.charAt(i)==colors.charAt(i+1)){
                i++;
                maxi=Math.max(maxi,neededTime[i]);
                sum+=neededTime[i];
            }
            cost+=sum-maxi;
            maxi=0;
            i++;
        }
        return cost;
    }
}