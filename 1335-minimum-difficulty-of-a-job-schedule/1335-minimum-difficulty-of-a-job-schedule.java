class Solution {
    public int minDifficulty(int[] A, int D) {
        int n = A.length;
        if (n < D) return -1;
        int[] dp = new int[n], dp2 = new int[n], tmp;
        Arrays.fill(dp, 1000);
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int d = 0; d < D; ++d) {
            stack.clear();
            for (int i = d; i < n; i++) {
                dp2[i] = i > 0 ? dp[i - 1] + A[i] : A[i];
                while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                    int j = stack.pop();
                    dp2[i] = Math.min(dp2[i], dp2[j] - A[j] + A[i]);
                }
                if (!stack.isEmpty()) {
                    dp2[i] = Math.min(dp2[i], dp2[stack.peek()]);
                }
                stack.push(i);
            }
            tmp = dp;
            dp = dp2;
            dp2 = tmp;
        }
        return dp[n - 1];
    }
    
}