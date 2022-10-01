class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String res="";
        for(int i=0;i<arr.length-1;i++)
            res = res + reverse(arr[i]) + " ";
        res = res + reverse(arr[arr.length-1]);
        return res;
    }
    
    private String reverse(String str){
        String res = "";
        for(int i=0;i<str.length();i++)
            res = str.charAt(i) + res;
        return res;
    }
}