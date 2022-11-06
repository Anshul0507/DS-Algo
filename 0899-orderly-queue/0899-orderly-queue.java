class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            return new String(tempArray);
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if(s.compareTo(sb.toString())>0)
                s = sb.toString();
        }
        return s;
    }
}