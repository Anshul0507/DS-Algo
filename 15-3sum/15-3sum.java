class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n-2;i++){
            int lo = i+1, hi = n-1;
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int target = -nums[i];
                while(lo<hi){
                    if(nums[lo] + nums[hi]==target){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1])
                            lo++;
                        while(lo<hi && nums[hi]==nums[hi-1])
                            hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi]<target)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}