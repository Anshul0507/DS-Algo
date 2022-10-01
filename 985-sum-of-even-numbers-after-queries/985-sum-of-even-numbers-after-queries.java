class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int evenSum=0;
        for(int e: nums){
            if(e%2==0)
                evenSum+=e;
        }
        for(int i=0;i<n;i++){
            int idx = queries[i][1], val = queries[i][0];
            if(nums[idx]%2==0 && val%2==0)
                evenSum = evenSum + val;
            else if(nums[idx]%2==0 && (val%2==1 || val%2==-1))
                evenSum-=nums[idx];
            else if((nums[idx]%2==1 || nums[idx]%2==-1) && (val%2==1 || val%2==-1))
                evenSum += nums[idx] + val;
            nums[idx] += val;
            res[i]=evenSum;
        }
        return res;
    }
}