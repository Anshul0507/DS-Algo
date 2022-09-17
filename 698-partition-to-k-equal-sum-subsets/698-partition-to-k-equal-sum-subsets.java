class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int n=arr.length;
        int sum=0,max=-1000000;
        for(int x:arr)sum+=x;
        for(int x:arr)max=Math.max(max,x);
        if(sum%k!=0||max>sum/k)return false;
        //bucket = array for storing sum for each partition
        int[]bucket=new int[k];
        Arrays.sort(arr);
        return helper(arr,bucket,sum/k,n,n-1);
    }
    
    private boolean helper(int[]arr,int[]bucket,int target,int n,int index){
        if(index==-1){
            return true;
        }
        
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]+arr[index]<=target){
                System.out.println("Filling " + arr[index] + " in bucket " + i);
                bucket[i]+=arr[index];
                if(helper(arr,bucket,target,n,index-1))return true;
                bucket[i]-=arr[index];
                System.out.println("Removing " + arr[index] + " from bucket " + i);
            }
            //if we have not filled the bucket, then no need to iterate for rest
            if(bucket[i]==0)
                break;
        }
        return false;
    }
}