class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> h = new HashSet<>();
        h.add(0);
        int sumSoFar=nums[0];
        for(int i=1;i<nums.length;i++){
            sumSoFar+=nums[i];
            if(h.contains(sumSoFar%k))
                return true;
            h.add((sumSoFar-nums[i])%k);
        }
        return false;
    }
}