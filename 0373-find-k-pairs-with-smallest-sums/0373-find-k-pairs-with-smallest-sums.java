class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // priority queue of pair of indexes
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1,p2) -> nums1[p1.getKey()] + nums2[p1.getValue()] - nums1[p2.getKey()] - nums2[p2.getValue()]);
        for(int i=0;i<nums1.length && i<k; i++)
            pq.add(new Pair(i,0));
        while(k>0 && !pq.isEmpty()){
            k--;
            Pair<Integer,Integer> minSumIndex = pq.poll();
            res.add(Arrays.asList(nums1[minSumIndex.getKey()], nums2[minSumIndex.getValue()]));
            if(minSumIndex.getValue() == nums2.length-1)
                continue;
            pq.add(new Pair(minSumIndex.getKey(), minSumIndex.getValue() +1));
        }
        return res;
    }
}