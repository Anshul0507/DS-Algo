class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        List<Point> p1 = new ArrayList<>();
        List<Point> p2 = new ArrayList<>();
        for (int i = 0; i < n*n; i++) {
            if (A[i/n][i%n] == 1)
                p1.add(new Point(i/n, i%n));
            if (B[i/n][i%n] == 1)
                p2.add(new Point(i/n, i%n));
        }
        int[][] freq = new int[2*n][2*n];
        int res = 0;
        for (Point a : p1) {
            for (Point b : p2) {
                // String diff = (a.x-b.x)+" "+(a.y-b.y);
                // diffMap.put(diff, diffMap.getOrDefault(diff,0)+1);
                // if (diffMap.containsKey(diff))
                //     diffMap.put(diff, diffMap.get(diff)+1);
                // else
                //     diffMap.put(diff, 1);
                res = Math.max(res, ++freq[a.x-b.x + n][a.y-b.y + n]);
            }
        }
        return res;
    }
}