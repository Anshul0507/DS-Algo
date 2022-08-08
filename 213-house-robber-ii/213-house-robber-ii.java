class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    
    private int rob(int[] nums, int l, int r){
        int prev = 0, curr = 0;
        for(int i=l;i<=r;i++){
            int temp = Math.max(prev + nums[i],curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}