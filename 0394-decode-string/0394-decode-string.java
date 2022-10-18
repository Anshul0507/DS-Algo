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
            
            // if character is [ or alphabet
            else if(s.charAt(i)!=']')
                sb.append(s.charAt(i));
            
            // when we encounter ]
            else{
                // pop the number repitions of the current substring inside []
                int repitition = st.pop(), left = sb.length()-1;
                
                //move left to the index at which we get [
                while(sb.charAt(left)!='[')
                    left--;
                
                // delete [ from string builder
                sb.deleteCharAt(left);
                int right = sb.length();
                
                // the current builder will have the substring between [] 1 time
                // so we have to append the substring between left and right repititions -1 times
                while(repitition > 1){
                    repitition--;
                    sb.append(sb.substring(left,right));
                }   
            }
        }
        return sb.toString();
    }
}