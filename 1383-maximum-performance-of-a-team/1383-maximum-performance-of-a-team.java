class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] perf = new int[n][2];
        for (int i = 0; i < n; ++i)
            perf[i] = new int[] {speed[i], efficiency[i]};
        Arrays.sort(perf, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0, sumS = 0;
        for (int[] per : perf) {
            pq.add(per[0]);
            sumS = (sumS + per[0]);
            if (pq.size() > k) sumS -= pq.poll();
            res = Math.max(res, (sumS * per[1]));
        }
        return (int) (res % (long)(1e9 + 7));
    }
}