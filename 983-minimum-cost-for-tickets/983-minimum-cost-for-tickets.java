class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxD = days[days.length-1];
        int[] dp = new int[maxD+1];
        dp[0] = 0; //no days to travel, no need to spend anything..!!!
            
        int j=0; //to iterate days array
        for(int i=1;i<=maxD;i++)
        {
            if(j==days.length)
                break; //when we are done with our travel days we break.
            
            if(days[j] != i) // if the day is not a travel day, just put the previous day cost.
                dp[i] = dp[i-1];
            
            else
            {
                int one = costs[0] + dp[i-1];
                int seven = costs[1] + dp[Math.max(0, i-7)];
                int thirty = costs[2] + dp[Math.max(0, i-30)];
                
                dp[i] = Math.min(one, Math.min(seven, thirty));
                
                j++;
            }
        }
        
        //System.out.println(Arrays.toString(dp));
        return dp[days[days.length-1]];
    }
}