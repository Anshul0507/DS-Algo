class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int n = s.length();
        int[] count = new int[n+1];
        count[1]=count[0]=1;
        for(int i=2;i<=n;i++){
            char c1 = s.charAt(i-1), c2=s.charAt(i-2);
            if(c1>'0')
                count[i]=count[i-1];
            if(c2=='1' || (c2=='2' && c1<'7'))
                count[i]+=count[i-2];
        }
        return count[n];
    }
}