/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>[] dp = new ArrayList[n+1];
        List<TreeNode> res = new ArrayList<>();
        if(n%2==0)
            return res;
        dp[0]=res;
        TreeNode root = new TreeNode(0);
        List<TreeNode> res1 = new ArrayList<>();
        res1.add(root);
        dp[1]=res1; 
        return makeList(n,dp);
    }
    
    private List<TreeNode> makeList(int n, List<TreeNode>[] dp){
        if(dp[n]!=null)
            return dp[n];
         List<TreeNode> res = new ArrayList<>();
        for(int i=1; i<n;i+=2){
            List<TreeNode> leftSubtree = makeList(i,dp);
            List<TreeNode> rightSubtree = makeList(n-i-1,dp);
            for(TreeNode left : leftSubtree){
                for(TreeNode right : rightSubtree){
                    res.add(new TreeNode(0,left,right));
                }
            }
        }
        return dp[n]=res;
    }
}