class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> {
            if(a[0]==b[0])
                return b[1]-a[1];
            return a[0]-b[0];
        });
        int maxTillNow = -1,count=0;
        for(int i=properties.length-1;i>=0;i--){
            if(properties[i][1]<maxTillNow)
                count++;
            maxTillNow=Math.max(maxTillNow,properties[i][1]);
        }
        return count;
    }
}