class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] present = new boolean[26];
        for(int i=0;i<sentence.length();i++)
            present[sentence.charAt(i)-'a']=true;
        for(int i=0;i<26;i++)
            if(!present[i])
                return false;
        return true;
    }
}