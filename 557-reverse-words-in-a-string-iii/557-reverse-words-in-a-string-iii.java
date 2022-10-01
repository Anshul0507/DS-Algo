class Solution {
    public String reverseWords(String s) {
        String res="",curr="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                res+=curr + " ";
                curr="";
            }
            else
                curr = s.charAt(i) + curr;
        }
        res += curr;
        return res;
    }

}