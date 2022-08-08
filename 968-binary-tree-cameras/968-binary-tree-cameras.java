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
    int count = 0;
    public int minCameraCover(TreeNode root) {
        int rootState = inOrder(root);
        if(rootState == -1)
            return count+1;
        return count;
    }
    
    public int inOrder(TreeNode root){
        if(root==null)
            return 1;
        int l = inOrder(root.left);
        int r = inOrder(root.right);
        if(l==-1 || r==-1){
            count++;
            return 0;
        }
        if(l==0 || r==0)
            return 1;
        return -1;
    }
}