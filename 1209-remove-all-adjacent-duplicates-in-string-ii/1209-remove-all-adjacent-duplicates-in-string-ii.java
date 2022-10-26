class Solution {
    public String removeDuplicates(String s, int k) {
        String res = "";
        Stack<Pair<Character,Integer>> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            Pair<Character,Integer> prev = st.isEmpty()? null : st.peek();
            if(null==prev || prev.getKey()!=s.charAt(i))
                st.add(new Pair(s.charAt(i),1));
            else{
                if(prev.getValue()==k-1){
                    for(int j=1;j<k;j++)
                        st.pop();
                }
                else
                    st.add(new Pair(s.charAt(i),prev.getValue()+1));
            }
        }
        while(!st.isEmpty()){
            res = st.pop().getKey() + res;
        }
        return res;
    }
}