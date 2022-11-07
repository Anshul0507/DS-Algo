class Solution {
    public int maximum69Number (int n) {
        int a = n%10,b=(n/10)%10,c=(n/100)%10,d=n/1000;
        if(n<10){
            return 9;
        }
        if(n<100){
            if(b==6)
                return 90 + a;
            return 99;
        }
        if(n<1000){
            if(c==6)
                return 900 + b*10 + a;
            if(b==6)
                return 990 + a;
            return 999;
        }
        if(d==6)
            return 9000 + c*100 + b*10 + a;
        if(c==6)
            return 9900 + b*10 + a;
        if(b==6)
            return 9990 + a;
        return 9999;
    }
}