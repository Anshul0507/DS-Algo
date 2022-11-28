class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> userLoss = new HashMap<>();
        for(int[] match: matches){
            int u1 = match[0], u2 = match[1];
            userLoss.put(u2,userLoss.getOrDefault(u2,0)+1);
            userLoss.putIfAbsent(u1,0);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> zLoss = new ArrayList<>(), oneLoss = new ArrayList<>();
        userLoss.forEach((k,v)-> {
            if(v==0)
                zLoss.add(k);
            if(v==1)
                oneLoss.add(k);
        });
        Collections.sort(zLoss);
        Collections.sort(oneLoss);
        res.add(zLoss);
        res.add(oneLoss);
        return res;
    }
}