class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, c = nums[n-1],b = nums[n-2], a = nums[n-3];
        if(a+b>c)
            return a+b+c;
        int k = n-4;
        while(k>=0 && a+b<=c){
            int aNew = nums[k--];
            c=b;
            b=a;
            a=aNew;
        }
        if(a+b>c)
            return a+b+c;
        return 0;
    }
}