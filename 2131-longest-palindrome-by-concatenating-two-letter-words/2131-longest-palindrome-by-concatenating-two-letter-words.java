class Solution {
    public int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];
        int count = 0;
        for(String w: words){
            int i = w.charAt(0)-'a', j = w.charAt(1)-'a';
            if(freq[j][i]>0){
                count+=4;
                freq[j][i]--;
            }
            else{
                freq[i][j]++;
            }
        }
        boolean oddPresent = false;
        for(int i=0;i<26;i++)
            if(freq[i][i]>0)
                return count + 2;
        return count;
    }
}