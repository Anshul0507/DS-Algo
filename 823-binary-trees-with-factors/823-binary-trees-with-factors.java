class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
            freqMap.put(arr[i],1);
        int count = n, M = 1000000007;
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int q = arr[i]/arr[j];
                    long freqQuotient = freqMap.getOrDefault(q,0);
                    long freqCurr = freqMap.get(arr[j]);
                    int increase =(int) (freqQuotient%M * freqCurr%M)%M;
                    count = (count%M + increase%M)%M;
                    freqMap.put(arr[i],(freqMap.get(arr[i])%M+increase%M)%M);
                }
            }
        return count;
    }
}