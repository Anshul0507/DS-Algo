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
        dfs(root,targetSum,new ArrayList<>(),res);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> res){
        if(root==null)
            return;
        curr.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val){
            res.add(new ArrayList<Integer>(curr));
        }
        else{
            dfs(root.left,targetSum-root.val,curr,res);
            dfs(root.right,targetSum-root.val,curr,res);
        }
        curr.remove(curr.size()-1);
    }
}