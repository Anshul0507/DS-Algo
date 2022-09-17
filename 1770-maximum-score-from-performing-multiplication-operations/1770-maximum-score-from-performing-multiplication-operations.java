class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] mem = new Integer[multipliers.length][multipliers.length];
        return solve(0,0,nums,multipliers,mem);
    }
    
    private int solve(int l, int i, int[] nums, int[] multipliers, Integer[][] mem){
        if(i==multipliers.length)
            return 0;
        if(mem[l][i]!=null)
            return mem[l][i];
        int leftMax = nums[l]*multipliers[i] + solve(l+1,i+1,nums,multipliers,mem);
        int rightMax = nums[nums.length-(i-l)-1]*multipliers[i] + solve(l,i+1,nums,multipliers,mem);
        return mem[l][i] = Math.max(leftMax,rightMax);
    }
}