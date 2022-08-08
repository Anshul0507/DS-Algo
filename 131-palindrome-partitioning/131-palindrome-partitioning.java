class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isPalindromicSubstring = new boolean[s.length()][s.length()];
        checkOddPalindrome(s, isPalindromicSubstring);
        checkEvenPalindrome(s, isPalindromicSubstring);
        List<List<String>> res = new ArrayList<>();
        makeList(new ArrayList<>(),res,0,s,isPalindromicSubstring);
        return res;
    }
    
    private void makeList(List<String> curr, List<List<String>> res, int start, String s, boolean[][] isPalindromicSubstring){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindromicSubstring[start][i]){
                String str = s.substring(start,i+1);
                curr.add(str);
                makeList(curr,res,i+1,s,isPalindromicSubstring);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    private void checkOddPalindrome(String s, boolean[][] isPalindromicSubstring){
        int l = 0, m=0, r = 0;
        while(m<s.length()){
            if(l<0 || r==s.length()){
                m++;
                l=m;
                r=m;
                continue;
            }
            char left = s.charAt(l), right = s.charAt(r);
            if(left==right){
                isPalindromicSubstring[l][r]=true;
                l--;
                r++;
            }
            else{
                m++;
                l=m;
                r=m;
            }
        }
    }
    
    private void checkEvenPalindrome(String s, boolean[][] isPalindromicSubstring){
        int l = 0, m=1, r = 1;
        while(m<s.length()){
            if(l<0 || r==s.length()){
                m++;
                l=m-1;
                r=m;
                continue;
            }
            char left = s.charAt(l), right = s.charAt(r);
            if(left==right){
                isPalindromicSubstring[l][r]=true;
                l--;
                r++;
            }
            else{
                m++;
                l=m-1;
                r=m;
            }
        }
    }
}