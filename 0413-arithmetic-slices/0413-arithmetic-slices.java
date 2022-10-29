class Solution {
    public int numberOfArithmeticSlices(int[] nums) {   
        if(nums.length<3)
            return 0;
        int l = 0, r = 2, frames=0, res = 0;
        while(r<nums.length){
            while(r<nums.length && nums[r]-nums[r-1] == nums[l+1]-nums[l])
                r++;
            frames = r-l-2;
            res += frames*(frames+1)/2;
            l=r-1;
            r++;
        }
        return res;
    }
}