class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        backtrack(new StringBuilder(""),0,arr);
        return max;
    }
    
    private void backtrack(StringBuilder prev, int start, List<String> arr){
        if(max<prev.length())
            max = prev.length();
        for(int i=start; i<arr.size();i++){
            if(!isUnique(prev.toString(),arr.get(i))) continue;
            int prevLength = prev.length();
            backtrack(prev.append(arr.get(i)),i+1,arr);
            prev.delete(prevLength,prev.length());
        }
    }
    
    private boolean isUnique(String a, String b){
        int[] freq = new int[26];
        for(int i=0;i<a.length();i++)
            if(++freq[a.charAt(i)-'a']==2)
                return false;
        for(int i=0;i<b.length();i++)
            if(++freq[b.charAt(i)-'a']>=2)
                return false;
        return true;
    }
}