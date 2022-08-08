class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int peak = 1, valley = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1])
                peak = valley+1;
            else if(nums[i]<nums[i-1])
                valley = peak+1;
        }
        return Math.max(peak,valley);
    }
}