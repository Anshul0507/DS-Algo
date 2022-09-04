class Solution {
    public void sortColors(int[] nums) {
        int l=0,m=0,h=nums.length-1;
        while(m<=h){
            if(nums[m]==0)
                swap(l++,m++,nums);
            else if(nums[m]==1)
                m++;
            else if(nums[m]==2){
                swap(m,h--,nums);
            }
        }
    }
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}