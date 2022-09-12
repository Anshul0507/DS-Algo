class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if(tokens.length==0 || power<tokens[0])
            return 0;
        int score = 0,low =0, high = tokens.length-1;
        while(low<=high){
            while(low<high && power<tokens[low]){
                power+=tokens[high--];
                score--;
            }
            while(low<=high && power>=tokens[low]){
                power-=tokens[low++];
                score++;
            }
            if(low==high)
                break;
        }
        return score;
    }
}