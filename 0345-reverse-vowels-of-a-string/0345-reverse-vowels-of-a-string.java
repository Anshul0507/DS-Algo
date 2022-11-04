class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        String wov = "aeiouAEIOU";
        int r = s.length()-1;
        for(int i=0;i<s.length();i++){
            if(wov.contains(s.charAt(i)+"")){
                while(!wov.contains(s.charAt(r)+""))
                    r--;
                sb.append(s.charAt(r--));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    // private boolean isVowel(char ch){
    //     return ch=='a' || ch=='e' || ch=='i' || ch== 'o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    // }
}