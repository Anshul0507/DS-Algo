class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = new int[arr.length];
        for(int i=0;i<arr.length;i++)
            sorted[i]=arr[i];
        Arrays.sort(sorted);
        int res = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += sorted[i];
            if (sum1 == sum2) res += 1;
        }
        return res;
    }
}