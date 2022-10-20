class Solution {
    public int numSquares(int n) {
        if(n==Math.sqrt(n))
            return 1;
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> h = new HashSet<>();
        q.add(n);
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1;i<=size;i++){
                int curr = q.poll();
                int sq = (int)Math.sqrt(curr);
                if(curr==sq*sq)
                    return count;
                for(int j=1;j<=sq;j++){
                    if(h.contains(curr-j*j))
                        continue;
                    q.add(curr-j*j);
                    h.add(curr-j*j);
                }   
            }
            count++;
        }
        return -1;
    }
}