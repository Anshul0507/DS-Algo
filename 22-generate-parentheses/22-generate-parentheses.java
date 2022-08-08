class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        makeList(n,n,res,"");
        return res;
    }
    
    private void makeList(int leftRemaining, int rightRemaining, List<String> res, String curr){
        if(leftRemaining>rightRemaining)
            return;
        if(leftRemaining==0){
            while(rightRemaining>0){
                rightRemaining--;
                curr = curr + ")";
            }
            res.add(curr);
            return;
        }
        makeList(leftRemaining-1,rightRemaining,res,curr+"(");
        makeList(leftRemaining,rightRemaining-1,res,curr+")");
    }
}