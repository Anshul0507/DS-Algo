class Solution {
    public int trap(int[] height) {
        int w=0,n=height.length;
        int[] lb = new int[n];
        int[] rb = new int[n];
        lb[0]=-1;
        int maxOnLeftIdx=0;
        for(int i=1;i<n;i++){
            if(height[i]>height[maxOnLeftIdx])
                maxOnLeftIdx=i;
            lb[i]=maxOnLeftIdx;
        }
        
        rb[n-1]=n;
        int maxOnRightIdx=n-1;
        for(int i=n-2;i>=0;i--){
            if(height[i]>height[maxOnRightIdx])
                maxOnRightIdx=i;
            rb[i]=maxOnRightIdx;
        }
        
        for(int i=1;i<n-1;i++){
            if(lb[i]==i || rb[i]==i)
                continue;
            w+=Math.min(height[lb[i]],height[rb[i]])-height[i];
        }
        return w;
    }
}