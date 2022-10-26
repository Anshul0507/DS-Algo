class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //{0,5,1,5,5,0}
        //{0,5,1,1,5,0}
        int n = nums.length;
        if(n==1)
            return false;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // hm.put(0,-1);
        // for(int i=0;i<n;i++){
        //     sumSoFar+=nums[i];
        //     sumSoFar%=k;
        //     Integer prev = hm.get(sumSoFar);
        //     if (prev != null) {
        //         if (prev < i-1)
        //             return true;
        //     }
        //     else hm.put(sumSoFar, i);
        // }
        // return false;
        
        //HashSet solution
        HashSet<Integer> h = new HashSet<>();
        h.add(0);
        int sumSoFar=nums[0];
        for(int i=1;i<n;i++){
            sumSoFar+=nums[i];
            if(h.contains(sumSoFar%k))
                return true;
            h.add((sumSoFar-nums[i])%k);
        }
        return false;
    }
}