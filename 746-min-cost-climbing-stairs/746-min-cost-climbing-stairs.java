class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = cost[0], curr = cost[1];
        for(int i=2;i<cost.length;i++){
            int temp = curr;
            curr = Math.min(curr,prev) + cost[i];
            prev = temp;
        }
        return Math.min(curr,prev);
    }
}