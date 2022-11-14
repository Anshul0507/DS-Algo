class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1;i>=1;i--)
            sb.append(arr[i]).append(" ");
        sb.append(arr[0]);
        return sb.toString();
    }
}