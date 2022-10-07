class Point{
    int x;
    int y;
    int d;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
        this.d = x*x + y*y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length==k)
            return points;
        PriorityQueue<Point> pq = new PriorityQueue<Point>((p1,p2)-> p2.d-p1.d);
        for(int i=0;i<k;i++){
            pq.add(new Point(points[i][0],points[i][1]));
        }
        for(int i=k;i<points.length;i++){
            pq.add(new Point(points[i][0],points[i][1]));
            pq.poll();
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            Point curr = pq.poll();
            res[i][0]=curr.x;
            res[i][1]=curr.y;
        }
        return res;
    }
}