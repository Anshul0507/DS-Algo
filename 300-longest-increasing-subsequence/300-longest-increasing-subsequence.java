class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length, count=0, high=0;
        int[] res = new int[n];
        Arrays.fill(res,10001);
        res[0]=nums[0];
        for(int i=1;i<n;i++){
            int ceilIndex = getCeilIndex(0,high,res,nums[i]);
            if(ceilIndex>high)
                high = ceilIndex;
            res[ceilIndex] = nums[i];
        }
        for(int i = 0;i<n;i++){
            if(res[i]==10001)
                break;
            count++;
        }
        return count;
    }
    
    private int getCeilIndex(int low, int high, int[] arr, int t){
        if(t<=arr[low])
            return low;
        if(t>arr[high])
            return high+1;
        int mid = (low+high)/2;
        if(t==arr[mid])
            return mid;
        if(t>arr[mid]){
            if(mid+1<=high && t<=arr[mid+1])
                return mid+1;
            return getCeilIndex(mid+1,high,arr,t);
        }
        if(mid-1>=low && t>arr[mid-1])
            return mid;
        return getCeilIndex(low,mid-1,arr,t);
    }
}