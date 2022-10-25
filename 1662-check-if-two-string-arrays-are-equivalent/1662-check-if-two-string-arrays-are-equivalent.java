class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        for(String w1: word1)
            s1+=w1;
        String s2 = "";
        for(String w2: word2)
            s2+=w2;
        if(s1.equals(s2))
            return true;
        return false;
    }
}