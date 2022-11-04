class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int r = arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(isVowel(arr[i])){
                while(!isVowel(arr[r]))
                    r--;
                sb.append(arr[r--]);
            }
            else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch== 'o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }
}