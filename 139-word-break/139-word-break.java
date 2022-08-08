class Solution {
    public boolean wordBreak(String s, List<String> wordDict){
        HashSet<String> h = new HashSet<>(wordDict);
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            for(int j=Math.max(0,i-20);j<=i;j++){
                String curr = s.substring(j,i+1);
                if(h.contains(curr)){
                    if(j>0)
                        dp[i]+=dp[j-1];
                    else
                        dp[i]++;
                }
            }
        }
        return dp[n-1]==0?false:true;
    }
}