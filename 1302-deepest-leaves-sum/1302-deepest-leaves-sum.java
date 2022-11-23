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
    int maxHeight=0,sum=0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    
    private void dfs(TreeNode root, int currHeight){
        if(root==null)
            return;
        if(currHeight>maxHeight){
            maxHeight=currHeight;
            sum=0;
        }
        if(currHeight==maxHeight)
            sum+=root.val;
        dfs(root.left,currHeight+1);
        dfs(root.right,currHeight+1);
    }
}