class Solution {
    public int minFlipsMonoIncr(String s) {
    int one = 0;
    int flip =0;
    for(int i=0;i<s.length();i++)
    {
        if(s.charAt(i)=='1')
            one++;
        else
            flip++;
        if(flip>one)
            flip=one;
    }
    return flip;
    }
}