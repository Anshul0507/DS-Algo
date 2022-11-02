class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end))
            return 0;
        HashSet<String> h = new HashSet<>();
        for(String b : bank)
            h.add(b);
        if(!h.contains(end))
            return -1;
        int steps=0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1;i<=size;i++){
                String curr = q.poll();
                if(curr.equals(end))
                    return steps;
                addNeighbours(q,curr,h);
            }
            steps++;
        }
        return -1;
    }
    
    private void addNeighbours(Queue<String> q, String curr, HashSet<String> mutations){
        mutations.forEach(m -> {
            if(isNeighbour(curr,m))
                q.add(m);
        });
        mutations.remove(curr);
    }
    
    private boolean isNeighbour(String root, String child){
        int diff=0;
        for(int i=0;i<8;i++){
            if(root.charAt(i)!=child.charAt(i))
                diff++;
            if(diff>1)
                return false;
        }
        return diff==1;
    }
}