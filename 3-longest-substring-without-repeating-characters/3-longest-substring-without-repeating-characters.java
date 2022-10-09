class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        int n = s.length(),l=0,r=1,maxi=1;
        HashSet<Character> h = new HashSet<>();
        h.add(s.charAt(0));
        while(r<n){
            while(h.contains(s.charAt(r)) && l<r){
                h.remove(s.charAt(l++));
            }
            h.add(s.charAt(r));
            maxi=Math.max(maxi,r-l+1);
            r++;
        }
        return maxi;
    }
}