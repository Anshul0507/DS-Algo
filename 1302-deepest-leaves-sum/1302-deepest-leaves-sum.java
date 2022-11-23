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
    public int deepestLeavesSum(TreeNode root) {
        int h = getHeight(root,0);
        return getSum(root,0,h);
    }
    
    private int getSum(TreeNode root, int currHeight, int maxHeight){
        if(root==null)
            return 0;
        int currSum=0;
        if(currHeight==maxHeight-1)
            currSum=root.val;
        return currSum + getSum(root.left,currHeight+1,maxHeight) + getSum(root.right,currHeight+1,maxHeight);
    }
    
    private int getHeight(TreeNode root, int h){
        if(root==null)
            return h;
        return Math.max(getHeight(root.left,h+1),getHeight(root.right,h+1));
    }
}