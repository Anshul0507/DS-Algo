class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)
            return false;
        int left = 0, right = 0;
        HashSet<Integer> h = new HashSet<>();
        while(right<nums.length){
            h.add(nums[right++]);
            if(right-left>k)
                h.remove(nums[left++]);
            if(h.size()<right-left)
                return true;
        }
        return false;
    }
}