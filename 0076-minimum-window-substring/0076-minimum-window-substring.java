class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        int[] freq = new int[58];
        for(int i=0;i<t.length();i++)
            freq[t.charAt(i)-'A']++;
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while(end<s.length()){
            final char c1 = s.charAt(end);
            if(freq[c1-'A']>0)
                counter--;
            freq[c1-'A']--;
            end++;
            while (counter == 0) {
                if(minLen > end - start){
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                freq[c2-'A']++;
                if (freq[c2-'A'] > 0)
                    counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}