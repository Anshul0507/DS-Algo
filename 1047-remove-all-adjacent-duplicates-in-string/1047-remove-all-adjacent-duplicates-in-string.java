class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length()-1;i++){
            if(i>=0 && sb.charAt(i)==sb.charAt(i+1)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i-=2;
            }
        }
        return sb.toString();
    }
}