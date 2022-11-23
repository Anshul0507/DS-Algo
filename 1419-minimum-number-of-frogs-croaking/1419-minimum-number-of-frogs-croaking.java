class Solution {
    public int minNumberOfFrogs(String cf) {
        int n = cf.length();
        if(n%5!=0)
            return -1;
        int[] map = new int[5];
        int frogs=0,maxFrogs=0;
        for(int i=0;i<n;i++){
            char ch = cf.charAt(i);
            int index = "croak".indexOf(ch);
            map[index]++;
            if(index!=0 && map[index]>map[index-1])
                return -1;
            if(index==0)
                frogs++;
            if(index==4)
                frogs--;
            maxFrogs = Math.max(frogs,maxFrogs);
        }
        return frogs==0?maxFrogs:-1;
    }
}