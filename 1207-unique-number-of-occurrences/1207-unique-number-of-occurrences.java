class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int e: arr){
            hm.put(e,hm.getOrDefault(e,0)+1);
        }
        HashSet<Integer> freq = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if(!freq.add(entry.getValue()))
                return false;
        }
        return true;
    }
}