class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE,n=nums.length,res=-1;
        for(int i = 0; i<n-2;i++){
            int lo = i+1, hi = n-1;
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                while(lo<hi){
                    int currSum = nums[lo] + nums[i] + nums[hi];
                    if(diff>Math.abs(currSum-target)){
                        diff = Math.abs(currSum-target);
                        res=currSum;
                    }
                    if(diff==0)
                        return target;
                    else if(currSum<target)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}