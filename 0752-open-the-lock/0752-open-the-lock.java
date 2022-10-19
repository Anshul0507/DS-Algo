class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> h = new HashSet<>();
        for(String d: deadends){
            if(d.equals("0000"))
                return -1;
            h.add(d);
        }
        int minPath = 0;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(curr.equals(target))
                    return minPath;
                addNeighboursToQ(curr, h, q);
            }
            minPath++;
        }
        return -1;
    }
    
    private void addNeighboursToQ(String val, HashSet<String> h, Queue<String> q){
        for(int i=0;i<4;i++){
            StringBuilder sb = new StringBuilder(val);
            char curr = val.charAt(i),prev = (char)((int)curr - 1), next = (char)((int)curr + 1);
            if(curr=='0')
                prev = '9';
            else if(curr=='9')
                next = '0';
            sb.setCharAt(i,prev);
            String currStr1 = sb.toString();
            if(!h.contains(currStr1))
                q.add(currStr1);
            h.add(currStr1);
            sb.setCharAt(i,next);
            String currStr2 = sb.toString();
            if(!h.contains(currStr2))
                q.add(currStr2);
            h.add(currStr2);
        }
    }
}