class Solution {
    public int countVowelPermutation(int n) {
        int M = 1000000007;
        int[][] dp = new int[n][5];
        for(int i=0;i<5;i++)
            dp[0][i]=1;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<5;j++){
                List<Integer> nextList = nextIndexList(j);
                for(int k : nextList){
                    dp[i+1][k]= (dp[i+1][k]%M + dp[i][j]%M)%M;
                }
            }
        }
        int res=0;
        for(int i = 0;i<5;i++)
            res = (res%M + dp[n-1][i]%M)%M;
        return res;
    }
    
    private List<Integer> nextIndexList(int currentIndex){
        List<Integer> res = new ArrayList<>();
        if(currentIndex == 0){
            res.add(1);
            return res;
        }
        if(currentIndex == 1){
            res.add(0);
            res.add(2);
            return res;
        }
        if(currentIndex == 2){
            res.add(0);
            res.add(1);
            res.add(3);
            res.add(4);
            return res;
        }
        if(currentIndex == 3){
            res.add(2);
            res.add(4);
            return res;
        }
        res.add(0);
        return res;
    }
}