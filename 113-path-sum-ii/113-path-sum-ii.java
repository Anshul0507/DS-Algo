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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        dfs(root,targetSum,new ArrayList<>(),res);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> res){
        if(root==null && targetSum!=0)
            return;
        if(root==null){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(root.val);
        if(root.left!=null){
            List<Integer> left = new ArrayList<>(curr);
            dfs(root.left,targetSum-root.val,left,res);
        }
        if(root.right!=null){
            List<Integer> right = new ArrayList<>(curr);
            dfs(root.right,targetSum-root.val,right,res);
        }
        if(root.left==null && root.right==null){
            dfs(null,targetSum-root.val,curr,res);
        }
    }
}