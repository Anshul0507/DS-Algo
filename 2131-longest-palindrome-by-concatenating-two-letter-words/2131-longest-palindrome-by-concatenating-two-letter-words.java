class Solution {
    public int longestPalindrome(String[] words) {
        int result = 0;
        int[][] letterArr= new int[26][26];
        for (int i=0; i<words.length; i++) {
            int index1 = words[i].charAt(0) - 'a';
            int index2 = words[i].charAt(1) - 'a';
            if (letterArr[index2][index1] > 0) {
                --letterArr[index2][index1];  result += 4;
            } else ++letterArr[index1][index2];
        }
        for(int i=0; i<26; i++){
           if(letterArr[i][i]>0) return result + 2;
        }
        return result;
    }
}