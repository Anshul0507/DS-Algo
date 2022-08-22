class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
            return false;
        return checkPower(n);
    }
    
    private boolean checkPower(int n){
        if(n==1)
            return true;
        if(n%4!=0)
            return false;
        return checkPower(n/4);
    }
}