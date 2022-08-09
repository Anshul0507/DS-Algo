class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        Deque<Integer> dq = new LinkedList<>();
        dq.add(n-1);
        for(int i=n-2;i>=0;i--){
            if(dq.getFirst()>i+k)
                dq.pollFirst();
            dp[i]=nums[i]+dp[dq.getFirst()];
            while(dq.size()>0 && dp[dq.getLast()]<=dp[i])
                dq.pollLast();
            dq.addLast(i);
        }
        return dp[0];
    }
}