class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String curr = "1";
        for(int i=2;i<=n;i++){
            curr = countAndSay(curr);
        }
        return curr;
    }
    
    public String countAndSay(String s){
        String res = "";
        char curr = s.charAt(0);
        int currCount=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=curr){
                res = res + String.valueOf(currCount) + curr;
                curr = s.charAt(i);
                currCount=1;
            }
            else
                currCount++;
        }
        res = res + String.valueOf(currCount) + curr;
        return res;
    }
}