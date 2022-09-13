class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<pieces.length;i++)
            indexMap.put(pieces[i][0],i);
        for(int i = 0; i<arr.length;i++){
            if(!indexMap.containsKey(arr[i]))
                return false;
            int idx = indexMap.get(arr[i]);
            for(int j=0;j<pieces[idx].length;j++){
                if(i==arr.length || pieces[idx][j]!=arr[i])
                    return false;
                i++;
            }
            i--;
        }
        return true;
    }
}