class Solution {
    public String longestPalindrome(String str) {
        int n = str.length(); // calculcharAting size of string
        if (n < 2)
            return str; // if string is empty then size will be 0.
                  // if n==1 then, answer will be 1(single
                  // character will always palindrome)
 
        int maxLength = 1,start=0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while ( high < n && str.charAt(high) == str.charAt(i)) //increment 'high'                                  
                high++;
       
            while ( low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'                   
                low--;
       
            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high) ){
                low--;
                high++;
            }
 
            int length = high - low - 1;
            if (maxLength < length){
                maxLength = length;
                start=low+1;
            }
        }   
        return str.substring(start, start + maxLength);
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