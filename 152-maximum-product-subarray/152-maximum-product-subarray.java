class Solution {
    public int maxProduct(int[] nums) {
        int maxPre = nums[0], minPre = nums[0], maxSoFar = nums[0], maxHere, minHere;
        for(int i=1;i<nums.length;i++){
            maxHere=Math.max(nums[i],Math.max(nums[i]*maxPre,nums[i]*minPre));
            minHere=Math.min(nums[i],Math.min(nums[i]*maxPre,nums[i]*minPre));
            maxSoFar=Math.max(maxHere,maxSoFar);
            maxPre = Math.max(maxHere,minHere);
            minPre = Math.min(maxHere,minHere);
        }
        return maxSoFar;
    }
}