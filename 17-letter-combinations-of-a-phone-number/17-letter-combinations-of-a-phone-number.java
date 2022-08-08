class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder curr = new StringBuilder("");
        makeList(curr,res,0,digits,map);
        return res;
    }
    
    private void makeList(StringBuilder curr, List<String> res, int start, String dig, String[] map){
        if(start==dig.length()){
            res.add(curr.toString());
            return;
        }
        String valList = map[Character.getNumericValue(dig.charAt(start))];
        for(int i=0;i<valList.length();i++){
            curr.append(valList.charAt(i));
            makeList(curr,res,start+1,dig,map);
            curr.setLength(curr.length() - 1);
        }
    }
}