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
        StringBuilder builder = new StringBuilder();
        char curr = s.charAt(0);
        int currCount=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=curr){
                builder.append(currCount)
                    .append(curr);
                curr = s.charAt(i);
                currCount=1;
            }
            else
                currCount++;
        }
        builder.append(currCount)
                    .append(curr);
        return builder.toString();
    }
}