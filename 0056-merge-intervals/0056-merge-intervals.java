class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(intervals[0][0],intervals[0][1]));
        int currIdx = 0;
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]<=res.get(currIdx).get(1)){
                res.get(currIdx).set(1,Math.max(res.get(currIdx).get(1),intervals[i][1]));
            }
            else{
                res.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                currIdx++;
            }
        }
        int[][] op = new int[res.size()][2];
        for(int i=0;i<op.length;i++){
            op[i][0]=res.get(i).get(0);
            op[i][1]=res.get(i).get(1);
        }
        return op;
    }
}