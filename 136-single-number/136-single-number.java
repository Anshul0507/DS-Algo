class Solution {
    public int singleNumber(int[] nums) {
        int curr = nums[0];
        for(int i=1;i<nums.length;i++)
            curr ^= nums[i];
        return curr;
    }
}