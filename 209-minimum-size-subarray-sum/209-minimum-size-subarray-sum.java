class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right=0, currSum = nums[0], mini = nums.length+1;
        while(right<nums.length){
            // System.out.println(left + " " + right + " -> " + currSum);
            if(currSum>=target){
                if(left==right)
                    return 1;
                mini = Math.min(mini,right-left+1);
                currSum-=nums[left++];
            }
            else{
                right++;
                if(right<nums.length)
                    currSum+=nums[right];
            }
        }
        return mini==nums.length+1?0:mini;
    }
}