class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++)
            freq[s1.charAt(i)-'a']++;
        int left = 0, right = s1.length()-1;
        while(right<s2.length()){
            int[] temp = freq.clone();
            int i = left;
            for(; i<=right; i++){
                if(temp[s2.charAt(i)-'a']==0){
                    break;
                }
                else
                    temp[s2.charAt(i)-'a']--;
            }
            if(i==right+1)
                return true;
            left++;
            right++;
        }
        return false;
    }
}