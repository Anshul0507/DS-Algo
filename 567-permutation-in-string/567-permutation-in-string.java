class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
          return false;  
        } 
        
        // s1 and s2 consist of lowercase English letters 
        // there are 26 letters in the English alphabet
        int[] s1CharCount = new int[26];
        int[] s2CharCount = new int[26];
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        // For example s1 = "ab"; s2 = "eiba"
        // in ascii 'a' = 97, 'b' = 98 etc. 
        // 'a' - 'a' == 0 and 'b' - 'a' == 1 for s1CharCount
        // 'e' - 'a' == 4 and 'i' - 'a' == 8 for s2CharCount
        // after loop s1CharCount[0, 1] = 1 and s2CharCount[4, 8] = 1
        for (int i = 0; i < len1; i++) {
            s1CharCount[s1.charAt(i) - 'a']++;
            s2CharCount[s2.charAt(i) - 'a']++;
        }
        
        //That is, we take the "ei" part and check it
        //in this example arrays will not be equal
        if (Arrays.equals(s1CharCount, s2CharCount)) {          
            return true;
        }
        
        // Then we take next part "ib" == false
        // after we take and check "ba" == true
        for (int i = len1; i < len2; i++) {
            s2CharCount[s2.charAt(i) - 'a']++;
            s2CharCount[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(s1CharCount, s2CharCount)) {
                return true;
            } 
        }
        
        return false;
    }
}