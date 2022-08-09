class Solution {
    public String longestPalindrome(String s) {
        int[] odd = oddLongestPalindrome(s);
        int[] even = evenLongestPalindrome(s);
        if(odd[1]-odd[0] > even[1]-even[0])
            return s.substring(odd[0],odd[1]+1);
        return s.substring(even[0],even[1]+1);
    }
    
    private int[] oddLongestPalindrome(String s){
        int maxi=1, m=1, l=0, r=2;
        int[] ind = new int[]{0,0};
        while(m<s.length()-1){
            if(l<0 || r == s.length()){
                m++;
                l=m-1;
                r=m+1;
                continue;
            }
            if(s.charAt(l)==s.charAt(r)){
                if(maxi<r-l+1){
                    maxi = r-l+1;
                    ind[0]=l;
                    ind[1]=r;
                }
                l--;
                r++;
            }
            else{
                m++;
                l=m-1;
                r=m+1;
            }
        }
        return ind;
    }
    
    private int[] evenLongestPalindrome(String s){
        int maxi=1, m=1, l = m-1, r = m;
        int[] ind = new int[]{0,0};
        while(m<s.length()){
            if(l<0 || r == s.length()){
                m++;
                l=m-1;
                r=m;
                continue;
            }
            if(s.charAt(l)==s.charAt(r)){
                if(maxi<r-l+1){
                    maxi = r-l+1;
                    ind[0]=l;
                    ind[1]=r;
                }
                l--;
                r++;
            }
            else{
                m++;
                l=m-1;
                r=m;
            }
        }
        return ind;
    }
}