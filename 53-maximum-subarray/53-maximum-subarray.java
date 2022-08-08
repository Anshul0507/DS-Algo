class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxTillHere = 0;
        for(int i = 0;i<nums.length;i++){
            maxTillHere+=nums[i];
            maxSoFar = Math.max(maxSoFar,maxTillHere);
            if(maxTillHere<0)
                maxTillHere=0;
        }
        return maxSoFar;
    }
}