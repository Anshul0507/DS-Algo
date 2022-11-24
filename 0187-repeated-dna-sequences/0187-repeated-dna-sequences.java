class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<=10)
            return res;
        HashMap<String,Integer> h = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++)
            sb.append(s.charAt(i));
        h.put(sb.toString(),1);
        int left=0,r=10;
        while(r<s.length()){
            sb.append(s.charAt(r++));
            sb.deleteCharAt(0);
            String k = sb.toString();
            int v = h.getOrDefault(k,0);
            if(v==1)
                res.add(k);
            h.put(k,v+1);
        }
        return res;
    }
}