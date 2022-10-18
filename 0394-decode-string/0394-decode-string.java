class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            
            //push the integer value to stack
            if(s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <=9){
                int digit = s.charAt(i)-'0';
                while(s.charAt(i+1)!='['){
                    digit = digit*10 + s.charAt(i+1)-'0';
                    i++;
                }
                st.push(digit);
            }
            
            // 
            else if(s.charAt(i)!=']')
                sb.append(s.charAt(i));
            else{
                
                int repitition = st.pop(), left = sb.length()-1;
                while(sb.charAt(left)!='[')
                    left--;
                sb.deleteCharAt(left);
                int right = sb.length();
                for(int k = 1; k< repitition; k++){
                    sb.append(sb.substring(left,right));
                }
                    
            }
        }
        return sb.toString();
    }
}