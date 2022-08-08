class Solution {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int last = 2, secondLast = 1, count = 0;
        for(int i=3; i<=n;i++){
            count=last + secondLast;
            secondLast = last;
            last = count;
        }
        return count;
    }
}