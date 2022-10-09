class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        int n = s.length(),l=0,r=1,maxi=1;
        int[] map = new int[224];
        Arrays.fill(map,-1);
        map[s.charAt(0)-' ']=0;
        while(r<n){
            if(map[s.charAt(r)-' ']!=-1 && l<=map[s.charAt(r)-' '])
                l = map[s.charAt(r)-' ']+1;
            maxi=Math.max(maxi,r-l+1);
            map[s.charAt(r)-' ']=r++;
        }
        return maxi;
    }
}