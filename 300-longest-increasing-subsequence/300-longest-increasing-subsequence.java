class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] res = new int[n];
        Arrays.fill(res,10001);
        res[0]=nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(nums[i]<res[0])
                res[0]=nums[i];
            else if(nums[i]>res[len-1])
                res[len++]=nums[i];
            else
                res[getCeilIndex(-1,len-1,res,nums[i])] = nums[i];
        }
        return len;
    }
    
    private int getCeilIndex(int l, int r, int[] arr, int t){
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] >= t)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
}