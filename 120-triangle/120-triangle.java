class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=1;i< n; i++){
            List<Integer> row = triangle.get(i);
            int m = row.size();
            row.set(0, row.get(0) + triangle.get(i-1).get(0));
            row.set(m-1, row.get(m-1) + triangle.get(i-1).get(m-2));
            for(int j = 1;j< row.size()-1;j++){
                row.set(j, row.get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
            }
            triangle.set(i,row);
        }
        int mini = triangle.get(n-1).get(0);
        for(int j = 1; j < n ; j++)
            mini = Math.min(mini, triangle.get(n-1).get(j));
        return mini;
    }
}