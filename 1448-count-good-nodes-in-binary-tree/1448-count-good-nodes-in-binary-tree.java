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
    public int goodNodes(TreeNode root) {
        return 1 + dfs(root.left,root.val) + dfs(root.right,root.val);
    }
    
    private int dfs(TreeNode node, int val){
        if(node==null)
            return 0;
        if(node.val<val)
            return dfs(node.left,val) + dfs(node.right,val);
        else
            return 1 + dfs(node.left,node.val) + dfs(node.right,node.val);
    }
}