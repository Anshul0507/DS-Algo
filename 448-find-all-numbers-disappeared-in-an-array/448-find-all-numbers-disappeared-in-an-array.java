class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int idx = nums[i]-1;
            markNegative(nums,idx);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-1)
                res.add(i+1);
        }
        return res;
    }
    
    private void markNegative(int[] nums, int i){
        if(i<0 || nums[i]==-1)
            return;
        int idx = nums[i]-1;
        nums[i] = -1;
        markNegative(nums,idx);
    }
}