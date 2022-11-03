class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> hm = new HashMap<>();
        int[][] freq = new int[26][26];
        int count = 0;
        for(String w: words){
            int i = w.charAt(0)-'a', j = w.charAt(1)-'a';
            if(i==j)
                freq[i][j]++;
            else{
                //found a reverse for dislikes
                if(freq[j][i]>0){
                    count+=4;
                    freq[j][i]--;
                }
                else{
                    freq[i][j]++;
                }
            }
        }
        boolean oddPresent = false;
        for(int i=0;i<26;i++){
            if(freq[i][i]%2==1){
                oddPresent = true;
                count+=(freq[i][i]-1)*2;
            } 
            else
                count+=freq[i][i]*2;
        }
        if(oddPresent)
            return count + 2;
        return count;
    }
}