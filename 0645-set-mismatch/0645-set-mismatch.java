class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int sumDiff=0, sumSqDiff=0;
        for(int i=0;i<nums.length;i++){
            sumDiff += (nums[i] - (i+1));
            sumSqDiff += (nums[i]*nums[i] - (i+1)*(i+1));
        }
        res[0] = (sumSqDiff/sumDiff + sumDiff)/2;
        res[1] = res[0] - sumDiff;
        return res;
    }
}