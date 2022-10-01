class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        if(str.length==1)
            return new StringBuilder(str[0]).reverse().toString();
        for (int i = 0; i < str.length; i++)
            str[i] = new StringBuilder(str[i]).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (String st : str)
            result.append(st + " ");
        return result.toString().trim();
    }

}