class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int left = Math.max(ax1,bx1), right = Math.min(ax2,bx2), bottom = Math.max(ay1,by1), top = Math.min(ay2,by2);
        int middleArea = Math.max(0,right-left)*Math.max(0,top-bottom);
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - middleArea;
    }
}