class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = s.length();
        for(int i=0;i<sb.length()-1;i++){
            if(i>=0 && isBadSequence(sb.charAt(i)-'A',sb.charAt(i+1)-'A')){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i-=2;
            }
        }
        return sb.toString();
    }
    
    private boolean isBadSequence(int c1, int c2){
        return Math.abs(c1-c2)==32;
    }
}