class Solution {
    HashSet<String> h = new HashSet<>();
    Solution(){
        int c = 1;
        for(int i=1;i<=31;i++){
            String s = String.valueOf(c);
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            h.add(String.valueOf(ar));
            c*=2;
        }
    }
    public boolean reorderedPowerOf2(int n) {
        char[] ar = String.valueOf(n).toCharArray();
        Arrays.sort(ar);
        if(h.contains(String.valueOf(ar)))
            return true;
        return false;
    }
}