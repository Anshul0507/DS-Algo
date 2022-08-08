class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0, n=nums.length, i;
        for(i=0;i<n && i<=reach;i++){
            reach = Math.max(reach,nums[i]+i);
        }
        return i==n;
    }
}