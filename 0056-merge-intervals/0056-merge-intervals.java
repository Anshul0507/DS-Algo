class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int currIdx = 0;
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]<=res.get(currIdx)[1]){
                res.get(currIdx)[1]= Math.max(res.get(currIdx)[1],intervals[i][1]);
            }
            else{
                res.add(intervals[i]);
                currIdx++;
            }
        }
        return res.toArray(new int[0][]);
    }
}

// class SortByFirst implements Comparable<int[]>{
//     @Override
//     public int compare(int[] a, int[] b){
//         return a[0]-b[0];
//     }
// }