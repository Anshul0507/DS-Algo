class Solution {
    public int maxLength(List<String> arr) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder(""));
        for (String str : arr) {
            if (!isUnique(str)) continue;
            List<StringBuilder> resList = new ArrayList<>();
            for (StringBuilder candidate : res) {
                StringBuilder temp = new StringBuilder(candidate).append(str);
                if (isUnique(temp.toString())) resList.add(temp);
            }
            res.addAll(resList);
        }
        int ans = 0;
        for (StringBuilder str : res) ans = Math.max(ans, str.length());
        return ans;
    }
    
    private boolean isUnique(String str) {
        boolean[] used = new  boolean [26];
        char[] arr = str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(used[str.charAt(i)-'a'])
                return false;
            used[str.charAt(i) -'a'] = true;
        }
        return true;
    }

}