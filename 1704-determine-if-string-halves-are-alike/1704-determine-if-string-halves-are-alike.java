class Solution {
    public boolean halvesAreAlike(String s) {
        int leftVow = 0, rightVow=0;
        for(int i=0;i<s.length()/2;i++)
            if(isVowel(s.charAt(i)))
                leftVow++;
        for(int i=s.length()/2;i<s.length();i++)
            if(isVowel(s.charAt(i)))
                rightVow++;
        return leftVow==rightVow;
    }
    
    private boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch)!=-1;
    }
}