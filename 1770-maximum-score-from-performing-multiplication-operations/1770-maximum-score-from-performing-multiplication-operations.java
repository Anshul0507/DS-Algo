class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[] dp = new int[nums.length + 1];
        for (int m = multipliers.length - 1, delta = nums.length - multipliers.length; m >= 0; m--, delta++) {
            for (int i = 0; i < nums.length - delta; i++) {
                dp[i] = Math.max(dp[i] + multipliers[m] * nums[i + delta], dp[i + 1] + multipliers[m] * nums[i]);
            }
        }
        return dp[0];
    }
    
    // private int solve(int l, int i, int[] nums, int[] multipliers, Integer[][] mem){
    //     if(i==multipliers.length)
    //         return 0;
    //     if(mem[l][i]!=null)
    //         return mem[l][i];
    //     int leftMax = nums[l]*multipliers[i] + solve(l+1,i+1,nums,multipliers,mem);
    //     int rightMax = nums[nums.length-(i-l)-1]*multipliers[i] + solve(l,i+1,nums,multipliers,mem);
    //     return mem[l][i] = Math.max(leftMax,rightMax);
    // }
}