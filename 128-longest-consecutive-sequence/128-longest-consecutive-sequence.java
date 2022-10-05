class Solution {
    public int longestConsecutive(int[] nums) {
        int maxi = 1, n = nums.length;
        if(n==0)
            return 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            int v = nums[i];
            if(hmap.containsKey(v))
                continue;
            if(hmap.containsKey(v-1) && hmap.containsKey(v+1)){
                int l = hmap.get(v-1), r = hmap.get(v+1);
                hmap.put(v,l+r+1);
                hmap.put(v-l,l+r+1);
                hmap.put(v+r,l+r+1);
                maxi = Math.max(maxi, l + r + 1);
            }
            else if (hmap.containsKey(v-1)){
                int l = hmap.get(v-1);
                hmap.put(v,l+1);
                hmap.put(v-l,l+1);
                maxi = Math.max(maxi, l + 1);
            }
            else if(hmap.containsKey(v+1)){
                int r = hmap.get(v+1);
                hmap.put(v,r+1);
                hmap.put(v+r,r+1);
                maxi = Math.max(maxi,r + 1);
            }
            else
                hmap.put(v,1);
        }
        return maxi;
    }
}