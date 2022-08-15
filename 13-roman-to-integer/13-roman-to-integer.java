class Solution {
    Map<String,Integer> map = new HashMap<>();
    
    Solution(){
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
    }
    public int romanToInt(String s) {
        int curr = 0,i=0;
        for(;i<s.length()-1;i++){
            String str1 = String.valueOf(s.charAt(i)), str2 = String.valueOf(s.charAt(i+1));
            if(map.containsKey(str1+str2)){
                curr+=map.get(str1+str2);
                i++;
            }
            else
                curr+=map.get(str1);
        }
        if(i<s.length())
            curr+=map.get(String.valueOf(s.charAt(i)));
        return curr;
    }
}