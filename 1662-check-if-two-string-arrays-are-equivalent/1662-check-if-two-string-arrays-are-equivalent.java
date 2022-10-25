class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for(String w1: word1)
            sb1.append(w1);
        int pos = 0;
        StringBuilder sb2 = new StringBuilder();
        for(String w2: word2)
            sb2.append(w2);
        if(sb1.length()!=sb2.length())
            return false;
        for(int i=0;i<sb1.length();i++)
            if(sb1.charAt(i)!=sb2.charAt(i))
                return false;
        return true;
    }
}