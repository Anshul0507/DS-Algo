class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int curr = asteroids[i];
            if(curr>0){
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && curr*-1 > st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == curr*-1)
                    st.pop();
                else if(st.isEmpty() || st.peek()<0)
                    st.push(curr);
            }
        }
        int[] res = new int[st.size()];
        for(int i=res.length-1;i>=0;i--)
            res[i]=st.pop();
        return res;
    }
}