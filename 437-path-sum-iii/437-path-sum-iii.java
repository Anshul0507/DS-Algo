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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        return (int) dfs(root,(long) targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    
    private long dfs(TreeNode root, long target){
        if(root==null)
            return 0;
        long sum = 0;
        if(root.val==target)
            sum++;
        return sum + dfs(root.left,target-(long)root.val) + dfs(root.right,target-(long)root.val);
    }
}