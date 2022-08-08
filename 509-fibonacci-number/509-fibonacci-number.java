class Solution {
    public int fib(int n) {
        if(n<=1)
            return n;
        int a=0,b=1,curr=0;
        for(int i=2;i<=n;i++){
            curr = a+b;
            a=b;
            b=curr;
        }
        return curr;
    }
}