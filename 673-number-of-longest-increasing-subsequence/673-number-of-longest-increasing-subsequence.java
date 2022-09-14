class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        Integer[] tail = new Integer[nums.length];
        TreeMap<Integer, Integer>[] dp = new TreeMap[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = new TreeMap<>();
        }
        int size = 0;
        for(int num: nums) {
            int l = 0, r = size;
            while(l != r) {
                int m = (r + l) / 2;
                if(tail[m] >= num) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            tail[l] = num;
            Map.Entry<Integer, Integer> fE = dp[l].firstEntry();
            int curChoices = fE == null ? 0 : fE.getValue();
            if(l > 0) {
                int preChoices = dp[l - 1].firstEntry().getValue();
                Map.Entry<Integer, Integer> cE = dp[l - 1].ceilingEntry(num);
                preChoices -= cE == null ? 0 : cE.getValue();
                dp[l].put(num, curChoices + preChoices);
            } else {
                dp[0].put(num, curChoices + 1);
            }
            if(l == size) {
                size++;
            }
        }
        return dp[size - 1].firstEntry().getValue();
    }
}