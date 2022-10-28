class Solution {
    public int jump(int[] nums) {
        int start = 0, end = 0, maxend = 1, steps = 0, n = nums.length;
        while(end<n-1){
            steps++;
            maxend = end+1;
            for(int i=start;i<=end;i++){
                if(i+nums[i]>=n-1)
                    return steps;
                maxend = Math.max(maxend,i+nums[i]);
            }
            start = end+1;
            end = maxend;
        }
        return steps;
    }
}