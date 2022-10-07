class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n==1)
            return 1;
        int item1 = fruits[0], l = 0, r = 1;
        while(r<n && fruits[r]==item1)
            r++;
        if(r==n)
            return n;
        int item2 = fruits[r];
        int maxi = r-l+1;
        r++;
        while(r<n){
            if(fruits[r]!=item2 && fruits[r]!=item1){
                item2 = fruits[r];
                l = r-1;
                while(l>1 && fruits[l]==fruits[l-1])
                    l--;
                item1 = fruits[l];
            }
            maxi = Math.max(maxi,r-l+1);
            // System.out.println(l + " " + r + " -> " + maxi);
            r++;
        }
        // System.out.println();
        return maxi;
    }
}