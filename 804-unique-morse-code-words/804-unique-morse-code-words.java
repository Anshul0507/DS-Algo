class Solution {
    String[] map = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> h = new HashSet<>();
        for(String word : words){
            String curr = "";
            for(int i=0;i<word.length();i++){
                curr += map[word.charAt(i)-'a'];
            }
            h.add(curr);
        }
        return h.size();
    }
}