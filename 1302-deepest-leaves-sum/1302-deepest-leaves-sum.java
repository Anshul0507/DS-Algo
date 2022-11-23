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

class Pair{
    int height;
    int sum;
    Pair(int h, int s){
        this.height=h;
        this.sum=s;
    }
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Pair p = new Pair(0,0);
        dfs(root,0,p);
        return p.sum;
    }
    
    private void dfs(TreeNode root, int currHeight, Pair p){
        if(root==null)
            return;
        if(currHeight>p.height){
            p.height=currHeight;
            p.sum=0;
        }
        if(currHeight==p.height)
            p.sum+=root.val;
        dfs(root.left,currHeight+1,p);
        dfs(root.right,currHeight+1,p);
    }
}