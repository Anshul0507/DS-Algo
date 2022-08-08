class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        makeList(1,n,k,new ArrayList<>(),res);
        return res;
    }
    
    private void makeList(int i, int n, int k, List<Integer> curr, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i;j<=n;j++){
            curr.add(j);
            makeList(j+1,n,k-1,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}