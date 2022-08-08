class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        res.add(curr);
        for(int i=2;i<=numRows;i++){
            curr = new ArrayList<>();
            int prev=0;
            for(int p=0;p<i;p++){
                int val = (p==0 || p==i-1)?1:prev*(i-p)/p;
                prev = val;
                curr.add(val);
            }
            res.add(curr);
        }
        return res;
    }
}