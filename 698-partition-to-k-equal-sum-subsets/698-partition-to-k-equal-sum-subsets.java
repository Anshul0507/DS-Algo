class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int n=arr.length;
        int sum=0,max=-1000000;
        for(int x:arr)sum+=x;
        for(int x:arr)max=Math.max(max,x);
        if(sum%k!=0||max>sum/k)return false;
        //ss = array for storing sum for each partition
        int[]ss=new int[k];
        Arrays.sort(arr);
        return helper(arr,ss,sum/k,n,n-1);
    }
    boolean helper(int[]arr,int[]ss,int target,int n,int index){
        if(index==-1){
            return true;
        }
        
        for(int i=0;i<ss.length;i++){
            if(ss[i]+arr[index]<=target){
                ss[i]+=arr[index];
                if(helper(arr,ss,target,n,index-1))return true;
                ss[i]-=arr[index];
            }
            //if we have not filled the bucket, then no need to iterate for rest
            if(ss[i]==0)
                break;
        }
        return false;
    }
}