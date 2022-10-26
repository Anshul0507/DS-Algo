class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length,sumSoFar=0;
        if(n==1)
            return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            sumSoFar+=nums[i];
            if(hm.getOrDefault(sumSoFar%k,i)<i-1)
                return true;
            hm.putIfAbsent(sumSoFar%k,i);
        }
        return false;
    }
}