class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  fruits) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }
}