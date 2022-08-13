class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, sigma = n*(n+1)/2, s=0;
        for(int i=0;i<n;i++)
            s+=nums[i];
        return sigma-s;
    }
}