class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        makeList(candidates, target, 0, new ArrayList<>(),res);
        return res;
    }
    
    public void makeList(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i< candidates.length; i++){
            if(candidates[i]>target)
                return;
            curr.add(candidates[i]);
            makeList(candidates,target-candidates[i],i,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}